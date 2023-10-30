package com.rentme.resources;

import com.rentme.models.BookingDetails;
import com.rentme.models.Vehicle;
import com.rentme.services.VehicleBookingService;
import com.rentme.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class TransactionResources {

    @Autowired
    VehicleBookingService vehicleBookingService;

    // API to get all the booking details
    @GetMapping("/get/booking")
    public ResponseEntity<List<BookingDetails>> getBookings(){
        return ResponseEntity.ok(vehicleBookingService.getAllBookings());
    }

    // API to get the booking details of a specific customer using customerId
    @GetMapping("/get/booking/customer/{customerId}")
    public ResponseEntity<List<BookingDetails>> getBookingsOfCustomer(@PathVariable final String customerId){
        return ResponseEntity.ok(vehicleBookingService.getBookingsOfCustomer(customerId));
    }

    // API to get the booking details using bookingId
    @GetMapping("/get/booking('{bookingId}')")
    public ResponseEntity<BookingDetails> getBookingById(@PathVariable final String bookingId){
        return ResponseEntity.ok(vehicleBookingService.getBookingById(bookingId));
    }

    // API to add new booking for a specify customer
    @PostMapping("/add/booking")
    public ResponseEntity<BookingDetails> addBookingInfo(@Valid @RequestBody final BookingDetails bookingDetails,
                                         @RequestParam final String customerId,
                                         @RequestParam final String vehicleId){
        return ResponseEntity
                .accepted()
                .body(vehicleBookingService.addNewBooking(bookingDetails, customerId, vehicleId));
    }

    // API to update a booking using unique bookingId
    @PutMapping("/update/booking/{bookingId}")
    public ResponseEntity<BookingDetails> updateBookingInfo(@PathVariable String bookingId,
                                            @RequestParam
                                            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Optional<LocalDateTime> toTime,
                                            @RequestParam Optional<Vehicle> vehicle,
                                            @RequestParam Optional<Status> status){
        return ResponseEntity
                .accepted()
                .body(vehicleBookingService.updateBooking(bookingId, toTime, vehicle, status));
    }

    // API to delete a booking using specific bookingId
    @DeleteMapping("/delete/booking/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable String bookingId){
        return ResponseEntity.accepted().body(vehicleBookingService.deleteBooking(bookingId));
    }
}
