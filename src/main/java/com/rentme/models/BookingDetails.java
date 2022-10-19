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

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    Customer customer;

    @JsonIgnore
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

    // Set status - Submitted, Cancelled or Completed
    public void setStatus(String status) {
        switch(status){
            case "SUBMITTED": this.status = Status.SUBMITTED;break;
            case "CANCELLED": this.status = Status.CANCELLED;break;
            case "COMPLETED": this.status = Status.COMPLETED;break;
            default : this.status = Status.ERROR;
        }
    }

    // Getter and Setter Methods for bookingId

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    // Getter and Setter Methods for customer

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Getter and Setter Methods for vehicle

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // Getter and Setter Methods for bookingTime

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    // Getter and Setter Methods for FromTime

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime fromTime) {
        this.fromTime = fromTime;
    }

    // Getter and Setter Methods for ToTime

    public LocalDateTime getToTime() {
        return toTime;
    }

    public void setToTime(LocalDateTime toTime) {
        this.toTime = toTime;
    }

    // Getter and Setter Methods for status

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
