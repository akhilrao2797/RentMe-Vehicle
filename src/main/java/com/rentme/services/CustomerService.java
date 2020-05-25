package com.rentme.services;

import com.rentme.models.Customer;
import com.rentme.repository.CustomerRepository;
import com.rentme.utils.CustomerStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer postCustomer(Customer customer) {
        customer.setCustomerId();
        customer.setStatus(CustomerStatus.ACTIVE);
        return customerRepository.save(customer);
    }

    public Customer updateCustomerDetails(String customerId,
                                          Optional<String> address,
                                          Optional<String> mobile,
                                          Optional<String> emailId) {

        Optional<Customer> customer = customerRepository.findById(customerId);
        if(!customer.isPresent())
            return null;
        Customer currentCustomer = customer.get();
        if(address.isPresent())
            currentCustomer.setAddress(address.get());
        if(mobile.isPresent())
            currentCustomer.setMobile(mobile.get());
        if(emailId.isPresent())
            currentCustomer.setEmailId(emailId.get());
        customerRepository.save(currentCustomer);
        return currentCustomer;
    }

    public String deleteCustomer(String customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if(!customer.isPresent())
            return "Invalid Customer Id";
        Customer currentCustomer = customer.get();
        currentCustomer.setStatus(CustomerStatus.INACTIVE);
        customerRepository.save(currentCustomer);
        return "Successfully deleted";
    }

    public Customer getCustomer(String customerId) {
        Optional<Customer> customer = null;
        if((customer = customerRepository.findById(customerId)).isPresent())
            return customer.get();
        else
            return null;
    }

    public List<Customer> getCustomers(Optional<String> status) {
        if(!status.isPresent())
            return customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();
        switch(status.get()){
            case "ACTIVE" :
                customerList.addAll(customerRepository.findByStatus(CustomerStatus.ACTIVE));
                break;
            case "INACTIVE":
                customerList.addAll(customerRepository.findByStatus(CustomerStatus.INACTIVE));
                break;
            case "BLOCKED":
                customerList.addAll(customerRepository.findByStatus(CustomerStatus.BLOCKED));
                break;
            default:
                customerList.addAll(customerRepository.findAll());
        }
        return customerList;
    }
}
