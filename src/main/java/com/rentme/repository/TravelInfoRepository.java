package com.rentme.repository;

import com.rentme.models.TravelInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelInfoRepository extends JpaRepository<TravelInfo, Long> {
}
