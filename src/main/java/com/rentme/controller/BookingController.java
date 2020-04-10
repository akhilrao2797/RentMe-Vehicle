package com.rentme.controller;

import com.rentme.models.BookingDetails;
import com.rentme.services.VehicleBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class BookingController {

    @Autowired
    VehicleBookingService vehicleBookingService;

    @GetMapping("/get/bookings")
    public ResponseEntity getBookings(){
        return ResponseEntity.ok(vehicleBookingService.getAllBookings());
    }

    @GetMapping("/get/bookings/{customer}")
    public ResponseEntity getBookingsOfCustomer(@PathVariable final String customerId){
        return ResponseEntity.ok(vehicleBookingService.getBookingsOfCustomer(customerId));
    }

    @GetMapping("/get/bookings/{bookingId}")
    public ResponseEntity getBookingById(@PathVariable final String bookingId){
        return ResponseEntity.ok(vehicleBookingService.getBookingById(bookingId));
    }

    @PostMapping("/add/booking")
    public ResponseEntity addBookingInfo(@Valid @RequestBody final BookingDetails bookingDetails){
        return ResponseEntity.accepted().body(vehicleBookingService.addNewBooking(bookingDetails));
    }

}
