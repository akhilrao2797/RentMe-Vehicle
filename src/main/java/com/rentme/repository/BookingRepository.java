package com.rentme.repository;

import com.rentme.models.BookingDetails;
import com.rentme.models.Vehicle;
import com.rentme.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetails, String> {
    List<BookingDetails> findByCustomer(String customerId);
    BookingDetails findByBookingId(String bookingId);

    @Query("select bd.vehicle from BookingDetails bd where bd.fromTime >= ?1 and bd.toTime <= ?2 and (bd.status != ?3 and bd.status != ?4)")
    List<Vehicle> findBookingsWithinTime(LocalDateTime fromTime, LocalDateTime toTime, Status statusCompleted, Status statusCancelled);
}
