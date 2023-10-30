package com.rentme.resources;

import com.rentme.models.Customer;
import com.rentme.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CustomerResources {

    @Autowired
    CustomerService customerService;

    // API to add customer and return 200 OK upon Success
    @PostMapping("/add/customer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody final Customer customer){
        return ResponseEntity.ok(customerService.postCustomer(customer));
    }

    // API to update customer details like Address, Mobile and Email
    // Return Updated details as Response
    @PutMapping("/update/customer/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable String customerId,
                                            @RequestParam("address") Optional<String> address,
                                            @RequestParam("mobile") Optional<String> mobile,
                                            @RequestParam("email") Optional<String> emailId){
        return ResponseEntity
                .accepted()
                .body(customerService.updateCustomerDetails(customerId, address, mobile, emailId));
    }

    // API to delete a customer entry using customerId
    // Return the deleted customer details as response
    @DeleteMapping("/delete/customer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerId){
        return ResponseEntity
                .accepted()
                .body(customerService.deleteCustomer(customerId));
    }

    // API to fetch the customer details based on the customerId
    @GetMapping("/get/customer/{customerId}")
    public ResponseEntity<Optional<Customer>> getCustomerInfo(@PathVariable final String customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }
}
