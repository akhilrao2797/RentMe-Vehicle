package com.rentme.controller;

import com.rentme.models.Transaction;
import com.rentme.models.Vehicle;
import com.rentme.services.TransactionService;
import com.rentme.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping("/get/booking")
    public ResponseEntity getBookings(){
        return ResponseEntity.ok(transactionService.getAllBookings());
    }

    @GetMapping("/get/booking/customer/{customerId}")
    public ResponseEntity getBookingsOfCustomer(@PathVariable final String customerId){
        return ResponseEntity.ok(transactionService.getBookingsOfCustomer(customerId));
    }

    @GetMapping("/get/booking('{bookingId}')")
    public ResponseEntity getBookingById(@PathVariable final String bookingId){
        return ResponseEntity.ok(transactionService.getBookingById(bookingId));
    }

    @PostMapping("/add/booking")
    public ResponseEntity addBookingInfo(@Valid @RequestBody final Transaction transaction){
        return ResponseEntity
                .accepted()
                .body(transactionService.addNewBooking(transaction));
    }

    @PutMapping("/update/booking/{bookingId}")
    public ResponseEntity updateBookingInfo(@PathVariable String bookingId,
                                            @RequestParam
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<LocalDateTime> toTime,
                                            @RequestParam Optional<Vehicle> vehicle,
                                            @RequestParam Optional<Status> status){
        return ResponseEntity
                .accepted()
                .body(transactionService.updateBooking(bookingId, toTime, vehicle, status));
    }

    @DeleteMapping("/delete/booking/{bookingId}")
    public ResponseEntity deleteBooking(@PathVariable String bookingId){
        return ResponseEntity.accepted().body(transactionService.deleteBooking(bookingId));
    }
}
