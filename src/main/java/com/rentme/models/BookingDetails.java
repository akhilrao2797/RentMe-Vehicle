package com.rentme.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
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

    @OneToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    Vehicle vehicle;

    @PastOrPresent
    LocalDateTime bookingTime;

    @FutureOrPresent
    LocalDateTime fromTime;

    @FutureOrPresent
    LocalDateTime toTime;
}
