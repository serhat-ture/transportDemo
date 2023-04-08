package com.serhat.transportdemo.service;

import com.serhat.transportdemo.dto.StationDto;
import com.serhat.transportdemo.entity.Station;

import java.util.List;

public interface StationService {

    Station createStation(StationDto stationDto);

    List<Station> findAllStation();

    StationDto getStationById(Long id);

    StationDto updateStation( StationDto stationDto);



    void deleteStation(Long id);
}
