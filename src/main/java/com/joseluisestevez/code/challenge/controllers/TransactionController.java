package com.joseluisestevez.code.challenge.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.code.challenge.EnumTransactionStatus;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.CreateTransactionDto;
import com.joseluisestevez.code.challenge.dto.TransactionStatusInDto;
import com.joseluisestevez.code.challenge.dto.TransactionStatusOutDto;
import com.joseluisestevez.code.challenge.services.TransactionService;

@RestController
public class TransactionController {

    private final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/search")
    public List<Transaction> search() {
	return transactionService.findAll();
    }

    @PostMapping(value = "/create")
    public ResponseEntity<TransactionStatusOutDto> create(@RequestBody CreateTransactionDto createTransactionDto) {
	try {
	    LOG.debug("CreateTransaction [{}]", createTransactionDto);
	    Transaction tx = transactionService.createTransaction(createTransactionDto);
	    LOG.debug("New success tx [{}]", tx);

	    TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	    transactionStatusOutDto.setStatus(tx.getTransactionStatus().toString());
	    transactionStatusOutDto.setReference(tx.getReference());
	    transactionStatusOutDto.setFee(tx.getFee());
	    transactionStatusOutDto.setAmount(tx.getAmount());
	    LOG.debug("Sending transactionStatusOutDto[{}]", transactionStatusOutDto);

	    return new ResponseEntity<TransactionStatusOutDto>((TransactionStatusOutDto) transactionStatusOutDto,
		    new HttpHeaders(), HttpStatus.CREATED);
	} catch (Exception e) {
	    LOG.error("Error in create", e);
	    TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	    transactionStatusOutDto.setStatus(EnumTransactionStatus.INVALID.toString());
	    transactionStatusOutDto.setReference(createTransactionDto.getReference());
	    return new ResponseEntity<TransactionStatusOutDto>(transactionStatusOutDto, new HttpHeaders(),
		    HttpStatus.FORBIDDEN);

	}

    }

    @PostMapping(value = "/status")
    public TransactionStatusOutDto status(@RequestBody TransactionStatusInDto transactionStatusInDto) {
	TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	transactionStatusOutDto.setReference("111");
	transactionStatusOutDto.setStatus("sss");
	return transactionStatusOutDto;
    }

}