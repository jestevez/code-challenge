package com.joseluisestevez.code.challenge.db.dao;

import org.springframework.data.repository.CrudRepository;

import com.joseluisestevez.code.challenge.db.model.Account;

public interface AccountDao extends CrudRepository<Account, Long> {

}
