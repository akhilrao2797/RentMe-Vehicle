package com.rentme.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class BookingDetails {

    @Id
    String bookingId;

    @ManyToMany
    Customer customerId;

    @ManyToMany
    Vehicle vehicle;

    @PastOrPresent
    LocalDateTime bookingTime;

    @FutureOrPresent
    LocalDateTime fromTime;

    @FutureOrPresent
    LocalDateTime toTime;
}
