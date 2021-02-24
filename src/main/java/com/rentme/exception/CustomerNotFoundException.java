package com.rentme.exception;

import com.rentme.utils.ErrorCodeMapper;

public class CustomerNotFoundException extends RuntimeException {
    private int messageId;
    private String message;

    public CustomerNotFoundException(String message) {
        super(message);
        this.messageId = ErrorCodeMapper.getValue(message);
    }

    public int getMessageId() {
        return messageId;
    }
}
