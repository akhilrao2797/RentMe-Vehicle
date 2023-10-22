package com.rentme.exception;

import com.rentme.utils.ErrorCodeMapper;

public class VehicleNotFoundException extends RuntimeException {
    private int messageId;
    private String message;

    // Throw an exception with specific message when a vehicle is Not Found
    public VehicleNotFoundException(String message) {
        super(message);
        this.messageId = ErrorCodeMapper.getValue(message);
    }

    // Function to return the messageId
    public int getMessageId() {
        return messageId;
    }
}
