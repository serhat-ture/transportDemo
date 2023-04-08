package com.serhat.transportdemo.mapper;


import com.serhat.transportdemo.dto.StationDto;
import com.serhat.transportdemo.entity.Station;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StationMapper {
    @Autowired
    private ModelMapper modelMapper;


    // convert Entity into DTO
    public StationDto mapToDTO(Station station) {
        StationDto stationDto = modelMapper.map(station, StationDto.class);
        return stationDto;
    }

    // convert DTO to entity
    public Station mapToEntity(StationDto stationDto) {
        Station station = modelMapper.map(stationDto, Station.class);
        return station;
    }
}
