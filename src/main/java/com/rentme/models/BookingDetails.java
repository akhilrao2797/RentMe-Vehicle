package com.rentme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentme.utils.Status;
import com.rentme.validators.StatusConstraint;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
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
}
