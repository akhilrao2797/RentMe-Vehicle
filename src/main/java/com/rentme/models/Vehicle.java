package com.rentme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@JsonIgnoreProperties()
public class Vehicle {

    @Id
    String registrationId;

    @NotEmpty
    String model;

    @NotEmpty
    String rc;

    @NotNull
    long meterReading;
//
//    @NotNull
//    @JsonProperty("isFree")
//    boolean isFree = true;

    @NotNull
    int pricePerLitre;
}
