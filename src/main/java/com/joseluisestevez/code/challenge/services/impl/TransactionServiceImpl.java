package com.joseluisestevez.code.challenge.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.code.challenge.db.dao.TransactionDao;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> findAll() {
	return (List<Transaction>) transactionDao.findAll();
    }
}
