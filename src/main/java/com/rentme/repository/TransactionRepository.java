package com.rentme.repository;

import com.rentme.models.Transaction;
import com.rentme.models.Customer;
import com.rentme.models.Vehicle;
import com.rentme.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    List<Transaction> findByCustomer(Customer customer);
    Transaction findByBookingId(String bookingId);

    @Query("select v1 from Vehicle v1 left join Transaction bd on " +
            "bd.vehicle = v1 where bd.fromTime >= ?1 and bd.toTime <= ?2" +
            " and bd.status = ?3")
    List<Vehicle> findBookingsWithinTime(LocalDateTime fromTime, LocalDateTime toTime, Status status);
}
