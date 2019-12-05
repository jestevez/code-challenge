package com.joseluisestevez.code.challenge.services;

import java.util.List;

import com.joseluisestevez.code.challenge.db.model.Transaction;

public interface TransactionService {
    List<Transaction> findAll();
}
