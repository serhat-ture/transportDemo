package com.serhat.transportdemo.service.impl;

import com.serhat.transportdemo.dto.StationDto;
import com.serhat.transportdemo.entity.Station;
import com.serhat.transportdemo.exception.ResourceNotFoundException;
import com.serhat.transportdemo.mapper.RouteMapper;
import com.serhat.transportdemo.mapper.StationMapper;
import com.serhat.transportdemo.repository.RouteRepository;
import com.serhat.transportdemo.repository.StationRepository;
import com.serhat.transportdemo.service.StationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {

    private RouteRepository routeRepository;
    private RouteMapper routeMapper;
    private StationRepository stationRepository;
    private StationMapper stationMapper;

    public StationServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper, StationRepository stationRepository, StationMapper stationMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
    }

    @Override
    public Station createStation(StationDto stationDto) {
        Station station= stationMapper.mapToEntity(stationDto);
           return stationRepository.save(station);
    }

    @Override
    public List<Station> findAllStation() {

   List<Station> stations= stationRepository.findAll();
        return stations;

               /* stations
                .stream()
                .map(station -> stationMapper.mapToEntity(station))
                .collect(Collectors.toList());*/
    }

    @Override
    public StationDto getStationById(Long id) {

        Station station = stationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Station","id",id));

        return  stationMapper.mapToDTO(station);

    }

    @Override
    public StationDto updateStation(StationDto stationDto) {
        return null;
    }


    @Override
    public void deleteStation(Long id) {
        getStationById(id);
        stationRepository.deleteById(id);

    }
}



