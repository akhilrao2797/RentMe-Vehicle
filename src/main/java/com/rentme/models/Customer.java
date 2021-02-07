package com.rentme.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rentme.utils.CustomerStatus;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonPropertyOrder({"customerId", "name", "mobile", "emailId", "drivingLicense", "aadharNumber", "address", "status", "coupon"})
public class Customer {

    @Id
    String customerId;

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

    String coupon;

    @Email
    String emailId;

    @Column(unique = true)
    @Size(min = 10, max = 10)
    String mobile;

    @Enumerated(EnumType.STRING)
    CustomerStatus status;

    @JsonIgnore
    String password;



    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId() {
        this.customerId = UUID
                .randomUUID()
                .toString()
                .replace("-","")
                .toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
