package com.rentme.services;

import com.rentme.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VehicleBookingService {

    @Autowired
    BookingRepository bookingRepository;

    public ResponseEntity getAllBookings() {
        return ResponseEntity.ok(bookingRepository.findAll());
    }

    public ResponseEntity getBookingsOfCustomer(String customerId) {
        return ResponseEntity.ok(bookingRepository.findByCustomer(customerId));
    }
}
