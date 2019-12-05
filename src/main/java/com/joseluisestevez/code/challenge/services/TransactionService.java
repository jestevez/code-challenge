package com.joseluisestevez.code.challenge.services;

import java.util.List;

import com.joseluisestevez.code.challenge.controllers.ServiceException;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.CreateTransactionDto;

public interface TransactionService {

    List<Transaction> findAll();

    Transaction save(Transaction transaction);

    Transaction createTransaction(CreateTransactionDto createTransactionDto) throws ServiceException;
}
