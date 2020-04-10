package com.rentme.controller;

import com.rentme.models.Customer;
import com.rentme.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add/customer")
    public ResponseEntity addCustomer(@Valid @RequestBody final Customer customer){
        return ResponseEntity.ok(customerService.postCustomer(customer));
    }
}
