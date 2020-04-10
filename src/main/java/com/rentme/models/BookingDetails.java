package com.rentme.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class BookingDetails {

    @Id
    String bookingId = UUID
            .randomUUID()
            .toString()
            .replace("-","")
            .toUpperCase();

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "customerId")
    Customer customer;

    @OneToOne
    @JoinColumn(name = "vehicle_id", nullable = false, referencedColumnName = "registrationId")
    Vehicle vehicle;

    @PastOrPresent
    LocalDateTime bookingTime;

    @FutureOrPresent
    LocalDateTime fromTime;

    @FutureOrPresent
    LocalDateTime toTime;
}
