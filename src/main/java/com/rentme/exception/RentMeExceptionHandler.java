package com.rentme.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RentMeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public final ResponseEntity<CustomException> handleAllExceptions(CustomerNotFoundException ex){
        CustomException exception = new CustomException(400, ex.getMessageId(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public final ResponseEntity<CustomException> handleAllExceptions(VehicleNotFoundException ex){
        CustomException exception = new CustomException(400, ex.getMessageId(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }
}
