package com.joseluisestevez.code.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joseluisestevez.code.challenge.db.dao.TransactionDao;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.services.TransactionService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class TransactionServiceTest {
    @MockBean
    private TransactionDao transactionDao;

    @Autowired
    private TransactionService transactionService;

    @Test
    void testFindByReference() {
	String reference = "12345A";
	String channel = EnumTypeChannel.CLIENT.toString();
	Transaction transaction = new Transaction();
	transaction.setReference(reference);
	Mockito.when(transactionService.findByReferenceAndChannel(Mockito.eq(reference), Mockito.eq(channel)))
		.thenReturn(transaction);

	Transaction tx = transactionService.findByReferenceAndChannel(reference, channel);
	assertEquals(reference, tx.getReference(), "Expected equals");
    }

}
