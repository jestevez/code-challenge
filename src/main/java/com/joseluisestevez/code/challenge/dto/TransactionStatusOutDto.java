package com.joseluisestevez.code.challenge.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class TransactionStatusOutDto implements Serializable {

    private static final long serialVersionUID = 560652835496189064L;

    @JsonProperty("reference")
    private String reference;
    @JsonProperty("status")
    private String status;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("fee")
    private BigDecimal fee;

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
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

}
