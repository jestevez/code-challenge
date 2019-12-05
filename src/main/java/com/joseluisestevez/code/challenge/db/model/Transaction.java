package com.joseluisestevez.code.challenge.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.joseluisestevez.code.challenge.EnumTransactionStatus;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 2055535404445476401L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "account_iban")
    private String accountIban;

    @Column(name = "tx_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txDate;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "base_amount")
    private BigDecimal baseAmount;

    @Column(name = "fee")
    private BigDecimal fee;

    @Column(name = "description")
    private String description;

    @Column(name = "movement_type")
    private String movementType;

    @Column(name = "transaction_status")
    @Enumerated(EnumType.STRING)
    private EnumTransactionStatus transactionStatus;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

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

    public BigDecimal getBaseAmount() {
	return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
	this.baseAmount = baseAmount;
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

    public String getMovementType() {
	return movementType;
    }

    public void setMovementType(String movementType) {
	this.movementType = movementType;
    }

    public EnumTransactionStatus getTransactionStatus() {
	return transactionStatus;
    }

    public void setTransactionStatus(EnumTransactionStatus transactionStatus) {
	this.transactionStatus = transactionStatus;
    }

    public Date getCreateAt() {
	return createAt;
    }

    public void setCreateAt(Date createAt) {
	this.createAt = createAt;
    }

}
