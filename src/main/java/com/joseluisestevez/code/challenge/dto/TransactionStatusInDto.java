package com.joseluisestevez.code.challenge.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionStatusInDto implements Serializable {

    private static final long serialVersionUID = -5862136916023081120L;

    @JsonProperty("reference")
    private String reference;
    @JsonProperty("channel")
    private String channel;

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public String getChannel() {
	return channel;
    }

    public void setChannel(String channel) {
	this.channel = channel;
    }

}
