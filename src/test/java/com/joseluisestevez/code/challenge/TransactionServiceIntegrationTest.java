package com.joseluisestevez.code.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.services.TransactionService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionServiceIntegrationTest {
    @Autowired
    private TransactionService transactionService;

    @Test
    void testFindByReference() {
	String reference = "000001";
	EnumTypeChannel channel = EnumTypeChannel.CLIENT;
	Transaction transaction = new Transaction();
	transaction.setReference(reference);

	Transaction tx = transactionService.findByReferenceAndChannel(reference, channel.toString());
	assertEquals(reference, tx.getReference(), "Expected equals");
    }

}