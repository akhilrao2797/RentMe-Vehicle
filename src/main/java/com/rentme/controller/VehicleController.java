package com.rentme.controller;

import com.rentme.models.Vehicle;
import com.rentme.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add/vehicle")
    public Vehicle addVehicle(@Valid @RequestBody final Vehicle vehicle){
        return vehicleService.postVehicle(vehicle);
    }

    @GetMapping("/get/vehicle/{vehicleId}")
    public ResponseEntity getVehicle(@PathVariable final String vehicleId){
        return ResponseEntity.ok(vehicleService.getVehicleDetails(vehicleId));
    }

    @DeleteMapping("/delete/vehicle/{vehicleId}")
    public ResponseEntity deleteVehicle(@PathVariable final String vehicleId){
        return ResponseEntity.ok(vehicleService.deleteVehicle(vehicleId));
    }

    @PutMapping("/update/vehicle/{vehicleId}")
    public ResponseEntity updateVehicle(@PathVariable final String vehicleId,
                                        @RequestParam Optional<Long> meterReading,
                                        @RequestParam Optional<Integer> pricePerLitre){
        return ResponseEntity.
                ok(vehicleService.updateVehicleDetails(vehicleId, meterReading, pricePerLitre));
    }

    @GetMapping("/free/vehicles")
    public ResponseEntity getAllFreeVehicles(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fromTime,
                                             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime toTime){
        return ResponseEntity.ok(vehicleService.getFreeVehicles(fromTime, toTime));
    }

}
