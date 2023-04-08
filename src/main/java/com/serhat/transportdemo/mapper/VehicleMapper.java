package com.serhat.transportdemo.mapper;


import com.serhat.transportdemo.dto.VehicleDto;
import com.serhat.transportdemo.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {
    @Autowired
    private ModelMapper modelMapper;


    // convert Entity into DTO
    public VehicleDto mapToDTO(Vehicle vehicle) {
        VehicleDto vehicleDto = modelMapper.map(vehicle, VehicleDto.class);
        return vehicleDto;
    }

    // convert DTO to entity
    public Vehicle mapToEntity(VehicleDto vehicleDto) {
        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        return vehicle;
    }
}
