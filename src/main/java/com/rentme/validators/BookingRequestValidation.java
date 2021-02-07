package com.rentme.validators;

import com.rentme.models.Transaction;
import com.rentme.repository.TransactionRepository;
import com.rentme.utils.Status;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BookingRequestValidation {

    public static boolean validateRequest(TransactionRepository transactionRepository,
                                          Transaction transaction) {
        List<Transaction> transactionList = transactionRepository
                .findByCustomer(transaction.getCustomer());
        long count = transactionList
                .stream()
                .filter(booking ->
                        !booking.getFromTime().isBefore(transaction.getFromTime()) &&
                        !booking.getToTime().isAfter(transaction.getToTime()) &&
                        !transaction.getStatus().equals(Status.SUBMITTED))
                .count();
        if(count == 0 &&
                transaction.getFromTime().isBefore(transaction.getToTime()) &&
                !transaction.getFromTime().isBefore(LocalDateTime.now()))
            return true;
        return false;
    }
}

