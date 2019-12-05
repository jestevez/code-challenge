package com.joseluisestevez.code.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.CreateTransactionDto;
import com.joseluisestevez.code.challenge.dto.TransactionStatusInDto;
import com.joseluisestevez.code.challenge.dto.TransactionStatusOutDto;
import com.joseluisestevez.code.challenge.services.TransactionService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/search")
    public List<Transaction> search() {
	return transactionService.findAll();
    }

    @PostMapping(value = "/create")
    public TransactionStatusOutDto create(@RequestBody CreateTransactionDto createTransactionDto) {
	TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	transactionStatusOutDto.setReference("111");
	transactionStatusOutDto.setStatus("sss");
	return transactionStatusOutDto;

    }

    @PostMapping(value = "/status")
    public TransactionStatusOutDto status(@RequestBody TransactionStatusInDto transactionStatusInDto) {
	TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	transactionStatusOutDto.setReference("111");
	transactionStatusOutDto.setStatus("sss");
	return transactionStatusOutDto;
    }

}
