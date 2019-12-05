package com.joseluisestevez.code.challenge.db.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.code.challenge.db.model.Account;

public interface AccountDao extends CrudRepository<Account, Long> {

    @Query("select a from Account a where a.instrumetNumber = ?1")
    Account findByInstrumetNumber(String instrumetNumber);

}
