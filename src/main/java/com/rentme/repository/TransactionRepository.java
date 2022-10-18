package com.rentme.repository;

import com.rentme.models.BookingDetails;
import com.rentme.models.Customer;
import com.rentme.models.Vehicle;
import com.rentme.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<BookingDetails, String> {
    List<BookingDetails> findByCustomer(Customer customer);
    BookingDetails findByBookingId(String bookingId);

    // SQL query to return all the vehicles with booking details between the fromTime and toTime

    @Query("select v1 from Vehicle v1 left join BookingDetails bd on " +
            "bd.vehicle = v1 where bd.fromTime >= ?1 and bd.toTime <= ?2" +
            " and bd.status = ?3")
    List<Vehicle> findBookingsWithinTime(LocalDateTime fromTime, LocalDateTime toTime, Status status);
}
