package com.rentme.services;

import com.rentme.models.BookingDetails;
import com.rentme.models.Vehicle;
import com.rentme.repository.TransactionRepository;
import com.rentme.utils.Status;
import com.rentme.validators.TransactionRequestValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleBookingService {

    TransactionRepository transactionRepository;
    CustomerService customerService;
    VehicleService vehicleService;

    @Autowired
    VehicleBookingService(TransactionRepository transactionRepository,
                          CustomerService customerService,
                          VehicleService vehicleService){
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
        this.vehicleService = vehicleService;
    }

    // Funtion to retrieve all the bookings
    public List<BookingDetails> getAllBookings() {
        return transactionRepository.findAll();
    }

    // Funtion to retrieve booking details of a specific customer
    public List<BookingDetails> getBookingsOfCustomer(String customerId) {
        return transactionRepository
                .findAll()
                .stream()
                .filter(booking -> booking.getCustomer().getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    // Funtion to add new booking
    public BookingDetails addNewBooking(BookingDetails bookingDetails,
                                        String customerId,
                                        String vehicleId) {
        bookingDetails.setCustomer(customerService.getCustomer(customerId).get());
        Optional<Vehicle> vehicleDetails = vehicleService.getVehicleDetails(vehicleId);
        if(vehicleDetails.isPresent())
            bookingDetails.setVehicle(vehicleDetails.get());
        else
            throw new NoSuchElementException("Vehicle does not exist");
        if(TransactionRequestValidation.validateRequest(transactionRepository,bookingDetails))
            return transactionRepository.save(bookingDetails);
        return null;
    }

    // Funtion to get booking details by bookingId
    public BookingDetails getBookingById(String bookingId) {
        return Optional.of(transactionRepository.findByBookingId(bookingId))
                .orElseThrow(null);
    }

    // Funtion to update booking details
    public BookingDetails updateBooking(String bookingId,
                                        Optional<LocalDateTime> toTime,
                                        Optional<Vehicle> vehicle,
                                        Optional<Status> status) {
        BookingDetails bookingDetails = transactionRepository.findByBookingId(bookingId);
        if(bookingDetails == null)
            return null;
        if(toTime.isPresent())
            bookingDetails.setToTime(toTime.get());
        if(vehicle.isPresent())
            bookingDetails.setVehicle(vehicle.get());
        if(status.isPresent())
            bookingDetails.setStatus(status.get().toString());
        transactionRepository.save(bookingDetails);
        return bookingDetails;
    }

    // Funtion to delete a booking
    public String deleteBooking(String bookingId) {
        BookingDetails bookingDetails = transactionRepository.findByBookingId(bookingId);
        if(bookingDetails == null)
            return "Booking id invalid";
        transactionRepository.delete(bookingDetails);
        return "Successfully deleted";
    }
}
