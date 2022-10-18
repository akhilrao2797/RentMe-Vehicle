package com.rentme.exception;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class CustomException implements Serializable {
    private int status;
    private int errorId;
    private String messageCode;
    private Timestamp timestamp;
    private String message;
    private static ResourceBundle resourceBundler =
            ResourceBundle.getBundle("i18n/MessageBundle");

    // Method to generate custom exception with status, errorId and messageCode
    public CustomException(int status, int errorId, String messageCode) {
        this.status = status;
        this.errorId = errorId;
        this.messageCode = messageCode;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.message = resourceBundler.getObject(messageCode).toString();
    }

    // Get Status
    public int getStatus() {
        return status;
    }

    // Get ErrorId
    public int getErrorId() {
        return errorId;
    }

    // Get MessageCode
    public String getMessageCode() {
        return messageCode;
    }

    // Get Timestamp
    public Timestamp getTimestamp() {
        return timestamp;
    }

    // Get Message
    public String getMessage() {
        return message;
    }
}
