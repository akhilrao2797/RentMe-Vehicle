package com.rentme.validators;

import com.rentme.models.BookingDetails;
import com.rentme.repository.TransactionRepository;
import com.rentme.utils.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TransactionRequestValidation {

        // Funtion to check if the request of booking detail is valid or not
    public static boolean validateRequest(TransactionRepository transactionRepository,
                                          BookingDetails bookingDetails) {
        List<BookingDetails> bookingDetailsList = transactionRepository
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

