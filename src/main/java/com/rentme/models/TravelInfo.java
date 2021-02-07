package com.rentme.models;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class TravelInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long travelInfoId;

    @PositiveOrZero
    Long startMeterReading;

    @Positive
    Long endMeterReading;

    @Embedded
    PaymentInfo paymentInfo;
}
