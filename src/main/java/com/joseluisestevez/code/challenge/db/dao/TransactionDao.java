package com.joseluisestevez.code.challenge.db.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.joseluisestevez.code.challenge.EnumTypeChannel;
import com.joseluisestevez.code.challenge.db.model.Transaction;

public interface TransactionDao
	extends PagingAndSortingRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

    @Query("select a from Transaction a where a.reference = ?1 AND a.channel = ?2")
    Transaction findByReferenceAndChannel(String reference, EnumTypeChannel channel);
}
