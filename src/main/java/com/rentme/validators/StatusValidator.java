package com.rentme.validators;

import com.rentme.utils.Status;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<StatusConstraint, Status> {
    @Override
    public void initialize(StatusConstraint constraint) {
    }

    @Override
    public boolean isValid(Status status, ConstraintValidatorContext constraintValidatorContext) {
        return status!=null ;
    }
}
