package com.rentme.controller;

import com.rentme.models.Vehicle;
import com.rentme.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping("/add/vehicle")
    public Vehicle addVehicle(@Valid @RequestBody final Vehicle vehicle){
        return vehicleService.postVehicle(vehicle);
    }
}
