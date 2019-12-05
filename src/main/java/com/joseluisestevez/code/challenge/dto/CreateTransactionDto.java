package com.joseluisestevez.code.challenge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateTransactionDto implements Serializable {

    private static final long serialVersionUID = -7950841095661610026L;

    @JsonProperty("reference")
    private String reference;
    @JsonProperty("account_iban")
    private String accountIban;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("fee")
    private BigDecimal fee;
    @JsonProperty("description")
    private String description;

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public String getAccountIban() {
	return accountIban;
    }

    public void setAccountIban(String accountIban) {
	this.accountIban = accountIban;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

    public BigDecimal getAmount() {
	return amount;
    }

    public void setAmount(BigDecimal amount) {
	this.amount = amount;
    }

    public BigDecimal getFee() {
	return fee;
    }

    public void setFee(BigDecimal fee) {
	this.fee = fee;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

}
