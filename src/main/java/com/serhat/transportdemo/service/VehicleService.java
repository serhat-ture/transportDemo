package com.serhat.transportdemo.service;

import com.serhat.transportdemo.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    VehicleDto createVehicle(long routeId, VehicleDto vehicleDto);

    List<VehicleDto> getVehiclesByRouteId(long routeId);

    VehicleDto getVehicleById(Long routeId, Long vehicleId);

    VehicleDto updateVehicle(Long routeId, long vehicleId, VehicleDto vehicleRequest);

    void deleteVehicle(Long routeId, Long vehicleId);
}
