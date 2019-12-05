package com.joseluisestevez.code.challenge.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 8996343861832236647L;

    @JsonProperty("reference")
    private String reference;
    @JsonProperty("account_iban")
    private String accountIban;
    @JsonProperty("date")
    private Date txDate;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("fee")
    private BigDecimal fee;
    @JsonProperty("description")
    private String description;
    @JsonProperty("status")
    private String transactionStatus;

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

    public Date getTxDate() {
	return txDate;
    }

    public void setTxDate(Date txDate) {
	this.txDate = txDate;
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

    public String getTransactionStatus() {
	return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
	this.transactionStatus = transactionStatus;
    }

}
