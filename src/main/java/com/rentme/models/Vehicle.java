package com.rentme.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Vehicle {

    @Id
    String registrationId;

    @NotEmpty
    String model;

    @NotEmpty
    String rc;

    @NotNull
    long meterReading;

    @NotNull
    int pricePerLitre;
}
