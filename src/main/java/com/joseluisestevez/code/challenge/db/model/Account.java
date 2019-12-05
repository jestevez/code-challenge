package com.joseluisestevez.code.challenge.db.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = -7531087040316251108L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "instrument_number")
    private String instrumetNumber;

    @Column(name = "balance")
    private BigDecimal balance;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getInstrumetNumber() {
	return instrumetNumber;
    }

    public void setInstrumetNumber(String instrumetNumber) {
	this.instrumetNumber = instrumetNumber;
    }

    public BigDecimal getBalance() {
	return balance;
    }

    public void setBalance(BigDecimal balance) {
	this.balance = balance;
    }

}
