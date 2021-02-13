package com.rentme.controller;

import com.rentme.models.Customer;
import com.rentme.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add/customer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody final Customer customer){
        return ResponseEntity.ok(customerService.postCustomer(customer));
    }

    @PutMapping("/update/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId,
                                            @RequestParam("address") Optional<String> address,
                                            @RequestParam("mobile") Optional<String> mobile,
                                            @RequestParam("email") Optional<String> emailId){
        return ResponseEntity
                .accepted()
                .body(customerService.updateCustomerDetails(customerId, address, mobile, emailId));
    }

    @DeleteMapping("/delete/customer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
        return ResponseEntity
                .accepted()
                .body(customerService.deleteCustomer(customerId));
    }

    @GetMapping("/get/customer/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerInfo(@PathVariable final String customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }
}
