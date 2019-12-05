package com.joseluisestevez.code.challenge.services;

import com.joseluisestevez.code.challenge.db.model.Account;

public interface AccountService {

    Account findByInstrumetNumber(String instrumetNumber);

    Account save(Account account);
}
