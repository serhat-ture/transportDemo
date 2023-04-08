package com.serhat.transportdemo.controller;

import com.serhat.transportdemo.dto.VehicleDto;
import com.serhat.transportdemo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class VehicleController {

    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/routes/{routeId}/vehicles")
    public ResponseEntity<VehicleDto> createVehicle(@PathVariable(value = "routeId") Long routeId,
                                                    @RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.createVehicle(routeId, vehicleDto), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    @GetMapping("/routes/{routeId}/vehicles")
    public List<VehicleDto> getVehiclesByRouteId(@PathVariable(value = "routeId") Long routeId) {
        return vehicleService.getVehiclesByRouteId(routeId);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
    @GetMapping("/routes/{routeId}/vehicles/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable(value = "routeId") Long routeId,
                                                     @PathVariable(value = "id") Long vehicleId) {
        VehicleDto vehicleDto = vehicleService.getVehicleById(routeId, vehicleId);
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') ")
    @PutMapping("/routes/{routeId}/vehicles/{id}")
    public ResponseEntity<VehicleDto> updateVehicle(@PathVariable(value = "routeId") Long routeId,
                                                    @PathVariable(value = "id") Long vehicleId,
                                                    @RequestBody VehicleDto vehicleDto) {

        VehicleDto updatedVehicle = vehicleService.updateVehicle(routeId, vehicleId, vehicleDto);
        return new ResponseEntity<>(updatedVehicle, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') ")
    @DeleteMapping("/routes/{routeId}/vehicles/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable(value = "routeId") Long routeId,
                                                @PathVariable(value = "id") Long vehicleId) {
        vehicleService.deleteVehicle(routeId, vehicleId);
        return new ResponseEntity<>("Vehicle deleted successfully", HttpStatus.OK);
    }


}
