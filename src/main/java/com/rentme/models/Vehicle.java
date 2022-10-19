package com.rentme.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    // Getter and Setter Methods

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public long getMeterReading() {
        return meterReading;
    }

    public void setMeterReading(long meterReading) {
        this.meterReading = meterReading;
    }

    public int getPricePerLitre() {
        return pricePerLitre;
    }

    public void setPricePerLitre(int pricePerLitre) {
        this.pricePerLitre = pricePerLitre;
    }
}
