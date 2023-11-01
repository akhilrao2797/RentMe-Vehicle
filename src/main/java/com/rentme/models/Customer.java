package com.rentme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentme.utils.CustomerStatus;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@Entity
public class Customer {

    @Id
    String customerId = UUID
            .randomUUID()
            .toString()
            .replace("-","")
            .toUpperCase();

    @NotEmpty
    String name;

    @Column(unique = true)
    @Size(min = 12, max = 12)
    String aadharNumber;

    @Size(min = 10)
    String address;

    @NotEmpty
    @Column(unique = true)
    String drivingLicense;

    @JsonIgnore
    String coupon;

    @Email
    String emailId;

    @Column(unique = true)
    @Size(min = 10, max = 10)
    String mobile;

    @Enumerated(EnumType.STRING)
    CustomerStatus status = CustomerStatus.ACTIVE;
}
