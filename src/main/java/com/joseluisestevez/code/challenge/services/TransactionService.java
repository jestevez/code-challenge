package com.joseluisestevez.code.challenge.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.CreateTransactionDto;
import com.joseluisestevez.code.challenge.exception.ServiceException;

public interface TransactionService {

    List<Transaction> findAll();

    Page<Transaction> search(String accountIban, String orderBy, String direction, int page, int size);

    Transaction save(Transaction transaction);

    Transaction createTransaction(CreateTransactionDto createTransactionDto) throws ServiceException;
}
