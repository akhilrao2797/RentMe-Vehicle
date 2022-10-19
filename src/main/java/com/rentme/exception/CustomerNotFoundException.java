package com.rentme.exception;

import com.rentme.utils.ErrorCodeMapper;

public class CustomerNotFoundException extends RuntimeException {
    private int messageId;
    private String message;

    // Throw an exception with specific message when a customer is Not Found
    public CustomerNotFoundException(String message) {
        super(message);
        this.messageId = ErrorCodeMapper.getValue(message);
    }

    // Funtion to return the messageId
    public int getMessageId() {
        return messageId;
    }
}
