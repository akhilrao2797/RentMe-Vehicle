package com.rentme.models;

import com.rentme.utils.Status;
import com.rentme.validators.StatusConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotNull
    LocalDateTime bookingTime;

    @FutureOrPresent
    @NotNull
    LocalDateTime fromTime;

    @FutureOrPresent
    @NotNull
    LocalDateTime toTime;

    @StatusConstraint
    Status status;

    public void setStatus(String status) {
        switch(status){
            case "SUBMITTED": this.status = Status.SUBMITTED;break;
            case "CANCELLED": this.status = Status.CANCELLED;break;
            case "COMPLETED": this.status = Status.COMPLETED;break;
        }
    }

}
