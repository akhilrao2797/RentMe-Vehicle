package com.rentme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    String customerId = UUID
            .randomUUID()
            .toString()
            .replace("-","")
            .toUpperCase();

    @NotEmpty
    String name;

    @Size(min = 16, max = 16)
    String aadharNumber;

    @Size(min = 10)
    String address;

    @NotEmpty
    String drivingLicense;

    @JsonIgnore
    String coupon;

    @Email
    String emailId;

    @Size(min = 10, max = 10)
    String mobile;
}
