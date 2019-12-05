package com.joseluisestevez.code.challenge.exception;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 8665212870224245172L;
    private final String serviceMessage;

    public ServiceException(String serviceMessage) {
	this.serviceMessage = serviceMessage;
    }

    public String getServiceMessage() {
	return serviceMessage;
    }

}
