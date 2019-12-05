package com.joseluisestevez.code.challenge.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.code.challenge.db.model.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Long> {

}
