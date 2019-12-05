package com.joseluisestevez.code.challenge.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joseluisestevez.code.challenge.db.dao.AccountDao;
import com.joseluisestevez.code.challenge.db.model.Account;
import com.joseluisestevez.code.challenge.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional(readOnly = true)
    public Account findByInstrumetNumber(String instrumetNumber) {
	return accountDao.findByInstrumetNumber(instrumetNumber);
    }

    @Override
    @Transactional
    public Account save(Account account) {
	return accountDao.save(account);
    }

}
