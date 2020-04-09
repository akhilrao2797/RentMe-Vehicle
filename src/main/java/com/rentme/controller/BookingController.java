package com.rentme.controller;

import com.rentme.services.VehicleBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BookingController {

    @Autowired
    VehicleBookingService vehicleBookingService;

    @GetMapping("/get/bookings")
    public ResponseEntity getBookings(){
        return vehicleBookingService.getAllBookings();
    }

    @GetMapping("/get/bookings/{customer}")
    public ResponseEntity getBookingsOfCustomer(@PathVariable final String customerId){
        return vehicleBookingService.getBookingsOfCustomer(customerId);
    }

}
