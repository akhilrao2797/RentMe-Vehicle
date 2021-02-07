package com.rentme.models;

import com.rentme.utils.PaymentStatus;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.PositiveOrZero;

@Embeddable
public class PaymentInfo {

    @Enumerated(value = EnumType.STRING)
    PaymentStatus status;

    @PositiveOrZero
    Long totalAmount;
}
