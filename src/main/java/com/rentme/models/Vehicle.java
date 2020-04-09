package com.rentme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Vehicle {

    @Id
    String registrationId;

    @NotEmpty
    String model;

    @NotEmpty
    String rc;

    @NotNull
    long meterReading;

    boolean isFree;

    @NotNull
    int pricePerLitre;
}
