package com.joseluisestevez.code.challenge.cucumber.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.En;

public class TransactionSteps extends AbstractSteps implements En {
    public TransactionSteps() {

    }

    @Given("A transaction that is not stored in our system")
    public void a_transaction_that_is_not_stored_in_our_system() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from any channel")
    public void i_check_the_status_from_any_channel() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @Then("The system returns the status {string}")
    public void the_system_returns_the_status(String string) {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @Given("A transaction that is stored in our system")
    public void a_transaction_that_is_stored_in_our_system() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from CLIENT or ATM channel  And the transaction date is before today")
    public void i_check_the_status_from_CLIENT_or_ATM_channel_And_the_transaction_date_is_before_today() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @Then("The system returns the status {string} And the amount substracting the fee")
    public void the_system_returns_the_status_And_the_amount_substracting_the_fee(String string) {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from INTERNAL channel And the transaction date is before today")
    public void i_check_the_status_from_INTERNAL_channel_And_the_transaction_date_is_before_today() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @Then("The system returns the status {string} And the amount And the fee")
    public void the_system_returns_the_status_And_the_amount_And_the_fee(String string) {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from CLIENT or ATM channel And the transaction date is equals to today")
    public void i_check_the_status_from_CLIENT_or_ATM_channel_And_the_transaction_date_is_equals_to_today() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from INTERNAL channel And the transaction date is equals to today")
    public void i_check_the_status_from_INTERNAL_channel_And_the_transaction_date_is_equals_to_today() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from CLIENT channel And the transaction date is greater than today")
    public void i_check_the_status_from_CLIENT_channel_And_the_transaction_date_is_greater_than_today() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from ATM channel And the transaction date is greater than today")
    public void i_check_the_status_from_ATM_channel_And_the_transaction_date_is_greater_than_today() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

    @When("I check the status from INTERNAL channel And the transaction date is greater than today")
    public void i_check_the_status_from_INTERNAL_channel_And_the_transaction_date_is_greater_than_today() {
	// Write code here that turns the phrase above into concrete actions
	throw new cucumber.api.PendingException();
    }

}
