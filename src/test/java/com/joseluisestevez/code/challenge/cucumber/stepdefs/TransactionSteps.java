package com.joseluisestevez.code.challenge.cucumber.stepdefs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.joseluisestevez.code.challenge.EnumTransactionStatus;
import com.joseluisestevez.code.challenge.EnumTypeChannel;
import com.joseluisestevez.code.challenge.db.model.Transaction;
import com.joseluisestevez.code.challenge.dto.TransactionStatusInDto;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class TransactionSteps extends AbstractSteps implements En {

    public TransactionSteps() {
    }

    @Given("A transaction that is not stored in our system")
    public void a_transaction_that_is_not_stored_in_our_system() {
	testContext().reset();
	Transaction transaction = new Transaction();
	transaction.setTransactionStatus(EnumTransactionStatus.INVALID);
	super.testContext().setPayload(transaction);
    }

    @When("I check the status from any channel")
    public void i_check_the_status_from_any_channel() {
	super.testContext().getPayload(Transaction.class).setTransactionStatus(EnumTransactionStatus.INVALID);
    }

    @Then("The system returns the status {string}")
    public void the_system_returns_the_status(String expectedStatus) {
	Transaction transaction = super.testContext().getPayload(Transaction.class);
	assertEquals("Expected equals", expectedStatus, transaction.getTransactionStatus().toString());
    }

    @Given("A transaction that is stored in our system")
    public void a_transaction_that_is_stored_in_our_system() {
	testContext().reset();
    }

    @When("I check the status from CLIENT or ATM channel And the transaction date is before today")
    public void i_check_the_status_from_CLIENT_or_ATM_channel_And_the_transaction_date_is_before_today() {
	TransactionStatusInDto transactionStatusInDto = new TransactionStatusInDto();
	transactionStatusInDto.setChannel(EnumTypeChannel.CLIENT.toString());
	transactionStatusInDto.setReference("000016");

	super.testContext().setPayload(transactionStatusInDto);
	executePost("/status");
    }

    @Then("The system returns the status {string} And the amount substracting the fee")
    public void the_system_returns_the_status_And_the_amount_substracting_the_fee(String expectedStatus) {
	RestAssured.defaultParser = Parser.JSON;
	Response response = testContext().getResponse();

	assertThat(response.statusCode()).isIn(200, 201);
	String status = response.jsonPath().getString("status");
	assertEquals("Expected equals", expectedStatus, status);
    }

    @When("I check the status from INTERNAL channel And the transaction date is before today")
    public void i_check_the_status_from_INTERNAL_channel_And_the_transaction_date_is_before_today() {
	TransactionStatusInDto transactionStatusInDto = new TransactionStatusInDto();
	transactionStatusInDto.setChannel(EnumTypeChannel.INTERNAL.toString());
	transactionStatusInDto.setReference("000017");

	super.testContext().setPayload(transactionStatusInDto);
	executePost("/status");
    }

    @Then("The system returns the status {string} And the amount And the fee")
    public void the_system_returns_the_status_And_the_amount_And_the_fee(String expectedStatus) {
	RestAssured.defaultParser = Parser.JSON;
	Response response = testContext().getResponse();

	assertThat(response.statusCode()).isIn(200, 201);
	String status = response.jsonPath().getString("status");
	assertEquals("Expected equals", expectedStatus, status);

    }

    @When("I check the status from CLIENT or ATM channel And the transaction date is equals to today")
    public void i_check_the_status_from_CLIENT_or_ATM_channel_And_the_transaction_date_is_equals_to_today() {
	TransactionStatusInDto transactionStatusInDto = new TransactionStatusInDto();
	transactionStatusInDto.setChannel(EnumTypeChannel.CLIENT.toString());
	transactionStatusInDto.setReference("000018");

	super.testContext().setPayload(transactionStatusInDto);
	executePost("/status");
    }

    @When("I check the status from INTERNAL channel And the transaction date is equals to today")
    public void i_check_the_status_from_INTERNAL_channel_And_the_transaction_date_is_equals_to_today() {
	TransactionStatusInDto transactionStatusInDto = new TransactionStatusInDto();
	transactionStatusInDto.setChannel(EnumTypeChannel.INTERNAL.toString());
	transactionStatusInDto.setReference("000019");

	super.testContext().setPayload(transactionStatusInDto);
	executePost("/status");
    }

    @When("I check the status from CLIENT channel And the transaction date is greater than today")
    public void i_check_the_status_from_CLIENT_channel_And_the_transaction_date_is_greater_than_today() {
	TransactionStatusInDto transactionStatusInDto = new TransactionStatusInDto();
	transactionStatusInDto.setChannel(EnumTypeChannel.CLIENT.toString());
	transactionStatusInDto.setReference("000020");

	super.testContext().setPayload(transactionStatusInDto);
	executePost("/status");
    }

    @When("I check the status from ATM channel And the transaction date is greater than today")
    public void i_check_the_status_from_ATM_channel_And_the_transaction_date_is_greater_than_today() {
	TransactionStatusInDto transactionStatusInDto = new TransactionStatusInDto();
	transactionStatusInDto.setChannel(EnumTypeChannel.ATM.toString());
	transactionStatusInDto.setReference("000021");

	super.testContext().setPayload(transactionStatusInDto);
	executePost("/status");
    }

    @When("I check the status from INTERNAL channel And the transaction date is greater than today")
    public void i_check_the_status_from_INTERNAL_channel_And_the_transaction_date_is_greater_than_today() {
	TransactionStatusInDto transactionStatusInDto = new TransactionStatusInDto();
	transactionStatusInDto.setChannel(EnumTypeChannel.INTERNAL.toString());
	transactionStatusInDto.setReference("000022");

	super.testContext().setPayload(transactionStatusInDto);
	executePost("/status");
    }

}
