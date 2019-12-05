package com.joseluisestevez.code.challenge.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joseluisestevez.code.challenge.EnumTransactionStatus;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.CreateTransactionDto;
import com.joseluisestevez.code.challenge.dto.TransactionStatusInDto;
import com.joseluisestevez.code.challenge.dto.TransactionStatusOutDto;
import com.joseluisestevez.code.challenge.services.TransactionService;

@RestController
public class TransactionController {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/search", params = { "orderBy", "direction", "page", "size" })
    public Page<Transaction> search(@RequestParam("accountIban") String accountIban,
	    @RequestParam("orderBy") String orderBy, @RequestParam("direction") String direction,
	    @RequestParam("page") int page, @RequestParam("size") int size) {
	return transactionService.search(accountIban, orderBy, direction, page, size);
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

	    return new ResponseEntity<>((TransactionStatusOutDto) transactionStatusOutDto, new HttpHeaders(),
		    HttpStatus.CREATED);
	} catch (Exception e) {
	    LOG.error("Error in create", e);
	    TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	    transactionStatusOutDto.setStatus(EnumTransactionStatus.INVALID.toString());
	    transactionStatusOutDto.setReference(createTransactionDto.getReference());
	    return new ResponseEntity<>(transactionStatusOutDto, new HttpHeaders(), HttpStatus.FORBIDDEN);

	}

    }

    @PostMapping(value = "/status")
    public ResponseEntity<TransactionStatusOutDto> status(@RequestBody TransactionStatusInDto transactionStatusInDto) {
	try {
	    Transaction tx = transactionService.findByReferenceAndChannel(transactionStatusInDto.getReference(),
		    transactionStatusInDto.getChannel());

	    if (tx == null) {
		return new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
	    }
	    TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	    transactionStatusOutDto.setReference(tx.getReference());
	    transactionStatusOutDto.setStatus(tx.getTransactionStatus().toString());
	    transactionStatusOutDto.setFee(tx.getFee());
	    transactionStatusOutDto.setAmount(tx.getAmount());
	    return new ResponseEntity<>((TransactionStatusOutDto) transactionStatusOutDto, new HttpHeaders(),
		    HttpStatus.CREATED);
	} catch (Exception e) {
	    LOG.error("Error in create", e);
	    TransactionStatusOutDto transactionStatusOutDto = new TransactionStatusOutDto();
	    transactionStatusOutDto.setStatus(EnumTransactionStatus.INVALID.toString());
	    transactionStatusOutDto.setReference(transactionStatusInDto.getReference());
	    return new ResponseEntity<>(transactionStatusOutDto, new HttpHeaders(), HttpStatus.FORBIDDEN);

	}
    }

}
