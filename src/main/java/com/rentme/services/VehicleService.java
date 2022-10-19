package com.rentme.services;

import com.rentme.models.Vehicle;
import com.rentme.repository.TransactionRepository;
import com.rentme.repository.VehicleRepository;
import com.rentme.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    VehicleRepository vehicleRepository;
    TransactionRepository transactionRepository;

    @Autowired
    VehicleService(VehicleRepository vehicleRepository, TransactionRepository transactionRepository){
        this.vehicleRepository = vehicleRepository;
        this.transactionRepository = transactionRepository;
    }

    public Vehicle postVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    // Funtion to get vehicle details
    public Optional<Vehicle> getVehicleDetails(String vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    // Funtion to delete a vehicle detail
    public String deleteVehicle(String vehicleId) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if(!vehicle.isPresent())
            return "Invalid Vehicle Id";
        vehicleRepository.deleteById(vehicleId);
        return "Successfully deleted";
    }

    // Funtion to update vehicle details
    public Vehicle updateVehicleDetails(String vehicleId,
                                        Optional<Long> meterReading,
                                        Optional<Integer> pricePerLitre) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleId);
        if(!vehicle.isPresent())
            return null;
        Vehicle currentVehicle = vehicle.get();
        if(pricePerLitre.isPresent())
            currentVehicle.setPricePerLitre(pricePerLitre.get());
        if(meterReading.isPresent())
            currentVehicle.setMeterReading(meterReading.get());
        vehicleRepository.save(currentVehicle);
        return currentVehicle;
    }

    public List<Vehicle> getFreeVehicles(LocalDateTime fromTime, LocalDateTime toTime) {
        List<Vehicle> bookedVehicles = transactionRepository
                .findBookingsWithinTime(fromTime, toTime, Status.SUBMITTED);
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles
                .stream()
                .filter(vehicle -> !bookedVehicles.contains(vehicle))
                .collect(Collectors.toList());
    }
}
