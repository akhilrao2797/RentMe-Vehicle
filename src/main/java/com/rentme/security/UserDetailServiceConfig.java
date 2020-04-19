package com.rentme.security;

import com.rentme.models.Customer;
import com.rentme.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceConfig implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmailId(emailId);
        if(!customer.isPresent())
            throw new UsernameNotFoundException("Email Id invalid");
        return new UserPrincipal(customer.get());
    }
}
