package com.serhat.transportdemo.service.impl;

import com.serhat.transportdemo.dto.StationDto;
import com.serhat.transportdemo.entity.Station;
import com.serhat.transportdemo.exception.ResourceNotFoundException;
import com.serhat.transportdemo.mapper.StationMapper;
import com.serhat.transportdemo.repository.StationRepository;
import com.serhat.transportdemo.service.StationService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;


@Service
public class StationServiceImpl implements StationService {

    private StationRepository stationRepository;
    private StationMapper stationMapper;

    public StationServiceImpl(StationRepository stationRepository,  StationMapper stationMapper) {
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
              }


    @Override
    public List<StationDto> getAllStations() {
        return stationRepository.findAll().stream().map(station -> stationMapper.mapToDTO(station)).collect(Collectors.toList());

    }

    @Override
    public StationDto getStationById(Long id) {

        Station station = stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station","id",id));
        return stationMapper.mapToDTO(station);
    }

    @Override
    public StationDto createStation(StationDto stationDto) {
        Station station = stationMapper.mapToEntity(stationDto);
        Station newStation = stationRepository.save(station);

        StationDto stationResponse = stationMapper.mapToDTO(newStation);
        return stationResponse;
    }

    @Override
    public StationDto updateStation(Long id, StationDto stationDto) {
        Station station = stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station", "id", id));
        station.setName(stationDto.getName());
        Station updatedStation= stationRepository.save(station);
        return stationMapper.mapToDTO(updatedStation);
    }



    @Override
    public void deleteStation(Long id) {
        Station station = stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station", "id", id));
        stationRepository.delete(station);

    }
}



