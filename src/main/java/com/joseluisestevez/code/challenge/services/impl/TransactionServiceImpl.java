package com.joseluisestevez.code.challenge.services.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.code.challenge.EnumTransactionStatus;
import com.joseluisestevez.code.challenge.exception.ServiceException;
import com.joseluisestevez.code.challenge.db.dao.AccountDao;
import com.joseluisestevez.code.challenge.db.dao.TransactionDao;
import com.joseluisestevez.code.challenge.db.model.Account;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.CreateTransactionDto;
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

	transaction.setBaseAmount(transaction.getAmount().add(transaction.getFee()));

	if (transaction.getBaseAmount().compareTo(account.getBalance()) > 0) {
	    throw new ServiceException("Insufficient money!");
	}

	if (account.getBalance().compareTo(BigDecimal.ZERO) > 0) {
	    transaction.setMovementType("CREDIT");
	    account.setBalance(account.getBalance().add(transaction.getBaseAmount()));
	} else {
	    transaction.setMovementType("DEBIT");
	    account.setBalance(account.getBalance().subtract(transaction.getBaseAmount()));
	}

	transaction.setCreateAt(new Date());
	transaction.setTxDate(new Date());
	transaction.setTransactionStatus(EnumTransactionStatus.ENDING);

	Transaction transactionSave = transactionDao.save(transaction);
	accountDao.save(account);
	return transactionSave;
    }
}
