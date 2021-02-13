package com.rentme.services;

import com.rentme.models.BookingDetails;
import com.rentme.models.Vehicle;
import com.rentme.repository.BookingRepository;
import com.rentme.utils.Status;
import com.rentme.validators.BookingRequestValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleBookingService {

    BookingRepository bookingRepository;
    CustomerService customerService;
    VehicleService vehicleService;

    @Autowired
    VehicleBookingService(BookingRepository bookingRepository,
                          CustomerService customerService,
                          VehicleService vehicleService){
        this.bookingRepository = bookingRepository;
        this.customerService = customerService;
        this.vehicleService = vehicleService;
    }

    public List<BookingDetails> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<BookingDetails> getBookingsOfCustomer(String customerId) {
        return bookingRepository
                .findAll()
                .stream()
                .filter(booking -> booking.getCustomer().getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }

    public BookingDetails addNewBooking(BookingDetails bookingDetails,
                                        String customerId,
                                        String vehicleId) {
        bookingDetails.setCustomer(customerService.getCustomer(customerId).get());
        Optional<Vehicle> vehicleDetails = vehicleService.getVehicleDetails(vehicleId);
        if(vehicleDetails.isPresent())
            bookingDetails.setVehicle(vehicleDetails.get());
        else
            throw new NoSuchElementException("Vehicle does not exist");
        if(BookingRequestValidation.validateRequest(bookingRepository,bookingDetails))
            return bookingRepository.save(bookingDetails);
        return null;
    }

    public BookingDetails getBookingById(String bookingId) {
        return Optional.of(bookingRepository.findByBookingId(bookingId))
                .orElseThrow(null);
    }

    public BookingDetails updateBooking(String bookingId,
                                        Optional<LocalDateTime> toTime,
                                        Optional<Vehicle> vehicle,
                                        Optional<Status> status) {
        BookingDetails bookingDetails = bookingRepository.findByBookingId(bookingId);
        if(bookingDetails == null)
            return null;
        if(toTime.isPresent())
            bookingDetails.setToTime(toTime.get());
        if(vehicle.isPresent())
            bookingDetails.setVehicle(vehicle.get());
        if(status.isPresent())
            bookingDetails.setStatus(status.get().toString());
        bookingRepository.save(bookingDetails);
        return bookingDetails;
    }

    public String deleteBooking(String bookingId) {
        BookingDetails bookingDetails = bookingRepository.findByBookingId(bookingId);
        if(bookingDetails == null)
            return "Booking id invalid";
        bookingRepository.delete(bookingDetails);
        return "Successfully deleted";
    }
}
