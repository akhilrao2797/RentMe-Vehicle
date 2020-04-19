package com.rentme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentme.utils.Status;
import com.rentme.validators.StatusConstraint;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class BookingDetails {

    @Id
    String bookingId = UUID
            .randomUUID()
            .toString()
            .replace("-","")
            .toUpperCase();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    Vehicle vehicle;

    @PastOrPresent
    @NotNull
    LocalDateTime bookingTime;

    @FutureOrPresent
    @NotNull
    LocalDateTime fromTime;

    @FutureOrPresent
    @NotNull
    LocalDateTime toTime;

    @Enumerated(EnumType.STRING)
    @StatusConstraint
    Status status;

    public void setStatus(String status) {
        switch(status){
            case "SUBMITTED": this.status = Status.SUBMITTED;break;
            case "CANCELLED": this.status = Status.CANCELLED;break;
            case "COMPLETED": this.status = Status.COMPLETED;break;
        }
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime fromTime) {
        this.fromTime = fromTime;
    }

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
