package com.joseluisestevez.code.challenge.services.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.code.challenge.EnumMovementType;
import com.joseluisestevez.code.challenge.EnumTransactionStatus;
import com.joseluisestevez.code.challenge.EnumTypeChannel;
import com.joseluisestevez.code.challenge.db.dao.AccountDao;
import com.joseluisestevez.code.challenge.db.dao.TransactionDao;
import com.joseluisestevez.code.challenge.db.model.Account;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.CreateTransactionDto;
import com.joseluisestevez.code.challenge.exception.ServiceException;
import com.joseluisestevez.code.challenge.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> findAll() {
	return (List<Transaction>) transactionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Transaction> search(String accountIban, String orderBy, String direction, int page, int size) {

	Sort sort = null;
	if (direction.equals(Sort.Direction.ASC.toString())) {
	    sort = Sort.by(Sort.Direction.ASC, orderBy);
	} else {
	    sort = Sort.by(Sort.Direction.DESC, orderBy);
	}
	Pageable pageable = PageRequest.of(page, size, sort);
	return transactionDao.findAll(new Specification<Transaction>() {

	    @Override
	    public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> query,
		    CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		if (accountIban != null) {
		    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("accountIban"), accountIban)));
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	}, pageable);

    }

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
	return transactionDao.save(transaction);
    }

    @Override
    @Transactional
    public Transaction createTransaction(CreateTransactionDto createTransactionDto) throws ServiceException {
	Account account = accountDao.findByInstrumetNumber(createTransactionDto.getAccountIban());
	if (account == null) {
	    throw new ServiceException("The account does not exist!");
	}
	Transaction transaction = new Transaction();

	DozerBeanMapper dozer = new DozerBeanMapper();
	dozer.map(createTransactionDto, transaction);

	if (createTransactionDto.getChannel() == null) {
	    createTransactionDto.setChannel(EnumTypeChannel.INTERNAL.toString());
	}
	transaction.setChannel(EnumTypeChannel.valueOf(createTransactionDto.getChannel()));
	transaction.setBaseAmount(transaction.getAmount().abs().add(transaction.getFee()).abs());
	transaction.setFee(createTransactionDto.getFee().abs());
	if (transaction.getBaseAmount().compareTo(account.getBalance()) > 0) {
	    throw new ServiceException("Insufficient money!");
	}

	if (transaction.getAmount().compareTo(BigDecimal.ZERO) > 0) {
	    transaction.setMovementType(EnumMovementType.CREDIT);
	    account.setBalance(account.getBalance().add(transaction.getBaseAmount()));
	} else {
	    transaction.setMovementType(EnumMovementType.DEBIT);
	    account.setBalance(account.getBalance().subtract(transaction.getBaseAmount()));
	}

	transaction.setAmount(createTransactionDto.getAmount().abs());
	transaction.setCreateAt(new Date());
	transaction.setTxDate(new Date());
	transaction.setTransactionStatus(EnumTransactionStatus.ENDING);

	Transaction transactionSave = transactionDao.save(transaction);
	accountDao.save(account);
	return transactionSave;
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction findByReferenceAndChannel(String reference, String channel) {
	return transactionDao.findByReferenceAndChannel(reference, EnumTypeChannel.valueOf(channel));
    }
}
