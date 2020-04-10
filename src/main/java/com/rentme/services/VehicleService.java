package com.rentme.services;

import com.rentme.models.Vehicle;
import com.rentme.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle postVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
