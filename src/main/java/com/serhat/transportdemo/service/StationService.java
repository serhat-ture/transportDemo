package com.serhat.transportdemo.service;

import com.serhat.transportdemo.dto.StationDto;
import com.serhat.transportdemo.entity.Station;


import java.util.List;

public interface StationService {

    List<StationDto> getAllStations();

    StationDto getStationById(Long id);

    StationDto createStation(StationDto stationDto);

    StationDto updateStation(Long id, StationDto stationDto);

    void deleteStation(Long id);
}
