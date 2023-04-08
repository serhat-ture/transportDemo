package com.serhat.transportdemo.service.impl;

import com.serhat.transportdemo.dto.VehicleDto;
import com.serhat.transportdemo.entity.Route;
import com.serhat.transportdemo.entity.Vehicle;
import com.serhat.transportdemo.exception.ResourceNotFoundException;
import com.serhat.transportdemo.mapper.VehicleMapper;
import com.serhat.transportdemo.repository.RouteRepository;
import com.serhat.transportdemo.repository.VehicleRepository;
import com.serhat.transportdemo.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleMapper vehicleMapper;
    private VehicleRepository vehicleRepository;
    private RouteRepository routeRepository;

    public VehicleServiceImpl(VehicleMapper vehicleMapper, VehicleRepository vehicleRepository, RouteRepository routeRepository) {
        this.vehicleMapper = vehicleMapper;
        this.vehicleRepository = vehicleRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public VehicleDto createVehicle(long routeId, VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.mapToEntity(vehicleDto);
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("Route","id",routeId));
        //we are maintaining routeId in vehicles table
        vehicle.setRoute(route);
        // vehicle entity to DB
        Vehicle newVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.mapToDTO(newVehicle);
    }

    @Override
    public List<VehicleDto> getVehiclesByRouteId(long routeId) {
        //we need list of vehicle entities
        List<Vehicle> vehicles = vehicleRepository.findByRouteId(routeId);
        // convert list of vehicle entities to list of vehicle dto's
        return vehicles.stream().map(vehicle -> vehicleMapper.mapToDTO(vehicle)).collect(Collectors.toList());
    }

    @Override
    public VehicleDto getVehicleById(Long routeId, Long vehicleId) {
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("Route","id",routeId));
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id",vehicleId));
        return vehicleMapper.mapToDTO(vehicle);
    }

    @Override
    public VehicleDto updateVehicle(Long routeId, long vehicleId, VehicleDto vehicleDto) {
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("Route","id",routeId));
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id",vehicleId));
         vehicle.setName(vehicleDto.getName());
       vehicle.setPlate(vehicleDto.getPlate());
    return null;
    }

    @Override
    public void deleteVehicle(Long routeId, Long vehicleId) {
        Route route = routeRepository.findById(routeId).orElseThrow(() -> new ResourceNotFoundException("Route","id",routeId));
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle", "id",vehicleId));
        vehicleRepository.delete(vehicle);
    }
}
