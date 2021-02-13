package com.rentme.validators;

import com.rentme.models.BookingDetails;
import com.rentme.repository.BookingRepository;
import com.rentme.utils.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BookingRequestValidation {

    public static boolean validateRequest(BookingRepository bookingRepository,
                                          BookingDetails bookingDetails) {
        List<BookingDetails> bookingDetailsList = bookingRepository
                .findByCustomer(bookingDetails.getCustomer());
        long count = bookingDetailsList
                .stream()
                .filter(booking ->
                        !booking.getFromTime().isBefore(bookingDetails.getFromTime()) &&
                        !booking.getToTime().isAfter(bookingDetails.getToTime()) &&
                        !bookingDetails.getStatus().equals(Status.SUBMITTED))
                .count();
        return count == 0 &&
                bookingDetails.getFromTime().isBefore(bookingDetails.getToTime()) &&
                !bookingDetails.getFromTime().isBefore(LocalDateTime.now());
    }
}

