package com.rentme.services;

import com.rentme.models.Vehicle;
import com.rentme.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public Vehicle postVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> getVehicleDetails(String vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    public String deleteVehicle(String vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if(vehicle.isPresent())
            return "Invalid Vehicle Id";
        vehicleRepository.deleteById(vehicleId);
        return "Successfully deleted";
    }

    public Vehicle updateVehicleDetails(String vehicleId,
                                        Optional<Long> meterReading,
                                        Optional<Integer> pricePerLitre) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if(vehicle.isPresent())
            return null;
        Vehicle currentVehicle = vehicle.get();
        if(pricePerLitre.isPresent())
            currentVehicle.setPricePerLitre(pricePerLitre.get());
        if(meterReading.isPresent())
            currentVehicle.setMeterReading(meterReading.get());
        vehicleRepository.save(currentVehicle);
        return currentVehicle;
    }
}
