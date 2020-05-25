package com.rentme.repository;

import com.rentme.models.Customer;
import com.rentme.utils.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByStatus(CustomerStatus status);
}
