package com.rentme.services;

import com.rentme.models.Customer;
import com.rentme.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer postCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
