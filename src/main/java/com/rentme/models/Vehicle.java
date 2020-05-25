package com.rentme.models;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Vehicle {

    @Id
    String registrationId;

    @NotEmpty
    String model;

    @Column(unique = true)
    @NotEmpty
    String rc;

    @NotNull
    long meterReading;

    @NotNull
    int pricePerLitre;



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
