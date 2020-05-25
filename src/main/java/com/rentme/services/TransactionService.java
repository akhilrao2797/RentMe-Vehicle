package com.rentme.services;

import com.rentme.models.Transaction;
import com.rentme.models.Vehicle;
import com.rentme.repository.TransactionRepository;
import com.rentme.utils.Status;
import com.rentme.validators.BookingRequestValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    TransactionRepository transactionRepository;
    CustomerService customerService;
    VehicleService vehicleService;

    @Autowired
    TransactionService(TransactionRepository transactionRepository,
                       CustomerService customerService,
                       VehicleService vehicleService){
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
        this.vehicleService = vehicleService;
    }

    public List<Transaction> getAllBookings() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getBookingsOfCustomer(String customerId) {
        return transactionRepository
                .findAll()
                .stream()
                .filter(booking -> booking.getCustomer().getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public Transaction addNewBooking(Transaction transaction) {
        transaction.setCustomer(customerService.getCustomer(transaction.getCustomer().getCustomerId()));
        transaction.setVehicle(vehicleService.getVehicleDetails(transaction.getVehicle().getRegistrationId()).get());
        if(BookingRequestValidation.validateRequest(transactionRepository, transaction)) {
            transaction.setBookingId();
            transaction.setBookingId();
            transaction.setStatus(Status.SUBMITTED);
            return transactionRepository.save(transaction);
        }
        return null;
    }

    public Transaction getBookingById(String bookingId) {
        return Optional.of(transactionRepository.findByBookingId(bookingId))
                .orElseThrow(null);
    }

    public Transaction updateBooking(String bookingId,
                                     Optional<LocalDateTime> toTime,
                                     Optional<Vehicle> vehicle,
                                     Optional<Status> status) {
        Transaction transaction = transactionRepository.findByBookingId(bookingId);
        if(transaction == null)
            return null;
        if(toTime.isPresent())
            transaction.setToTime(toTime.get());
        if(vehicle.isPresent())
            transaction.setVehicle(vehicle.get());
        if(status.isPresent())
            transaction.setStatus(status.get().toString());
        transactionRepository.save(transaction);
        return transaction;
    }

    public String deleteBooking(String bookingId) {
        Transaction transaction = transactionRepository.findByBookingId(bookingId);
        if(transaction == null)
            return "Booking id invalid";
        transactionRepository.delete(transaction);
        return "Successfully deleted";
    }
}
