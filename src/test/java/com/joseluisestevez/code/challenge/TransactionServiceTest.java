package com.joseluisestevez.code.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.joseluisestevez.code.challenge.db.dao.TransactionDao;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.services.TransactionService;

@RunWith(MockitoJUnitRunner.class)
class TransactionServiceTest {

    @Mock
    private TransactionDao transactionDao;

    @Mock
    private TransactionService transactionService;

    @Before
    public void init() {
	MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindByReference() {
	MockitoAnnotations.initMocks(this);

	String reference = "12345A";
	EnumTypeChannel channel = EnumTypeChannel.CLIENT;
	Transaction transaction = new Transaction();
	transaction.setReference(reference);
	Mockito.when(
		transactionService.findByReferenceAndChannel(Mockito.eq(reference), Mockito.eq(channel.toString())))
		.thenReturn(transaction);

	Transaction tx = transactionService.findByReferenceAndChannel(reference, channel.toString());
	assertEquals(reference, tx.getReference(), "Expected equals");
    }

}
