package com.rentme.services;

import com.rentme.models.BookingDetails;
import com.rentme.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleBookingService {

    @Autowired
    BookingRepository bookingRepository;

    public List<BookingDetails> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<BookingDetails> getBookingsOfCustomer(String customerId) {
        return bookingRepository.findByCustomer(customerId);
    }

    public BookingDetails addNewBooking(BookingDetails bookingDetails) {
        return bookingRepository.save(bookingDetails);
    }

    public BookingDetails getBookingById(String bookingId) {
        return bookingRepository.findByBookingId(bookingId);
    }
}
