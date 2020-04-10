package com.rentme.repository;

import com.rentme.models.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, String> {
    List<BookingDetails> findByCustomer(String customerId);
    BookingDetails findByBookingId(String bookingId);
}
