package com.rentme.resources;

import com.rentme.models.Vehicle;
import com.rentme.services.VehicleService;
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
public class VehicleResources {

    @Autowired
    VehicleService vehicleService;

    // API to add a new vehicle
    @PostMapping("/add/vehicle")
    public Vehicle addVehicle(@Valid @RequestBody final Vehicle vehicle){
        return vehicleService.postVehicle(vehicle);
    }

    // API to get vehicle details using the vehicleId
    @GetMapping("/get/vehicle/{vehicleId}")
    public ResponseEntity<Optional<Vehicle>> getVehicle(@PathVariable final String vehicleId){
        return ResponseEntity.ok(vehicleService.getVehicleDetails(vehicleId));
    }

    // API to delete the vehicle details using the vehicleId
    @DeleteMapping("/delete/vehicle/{vehicleId}")
    public ResponseEntity<String> deleteVehicle(@PathVariable final String vehicleId){
        return ResponseEntity.ok(vehicleService.deleteVehicle(vehicleId));
    }

    // API to update vehicle details using the vehicleId
    @PutMapping("/update/vehicle/{vehicleId}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable final String vehicleId,
                                        @RequestParam Optional<Long> meterReading,
                                        @RequestParam Optional<Integer> pricePerLitre){
        return ResponseEntity.
                ok(vehicleService.updateVehicleDetails(vehicleId, meterReading, pricePerLitre));
    }

    // API to remove the vehicles between two time intervals
    @GetMapping("/free/vehicles")
    public ResponseEntity<List<Vehicle>> getAllFreeVehicles(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromTime,
                                                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toTime){
        return ResponseEntity.ok(vehicleService.getFreeVehicles(fromTime, toTime));
    }

}
