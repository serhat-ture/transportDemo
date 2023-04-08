package com.serhat.transportdemo.service.impl;

import com.serhat.transportdemo.dto.RouteDto;
import com.serhat.transportdemo.entity.Route;
import com.serhat.transportdemo.exception.ResourceNotFoundException;
import com.serhat.transportdemo.mapper.RouteMapper;
import com.serhat.transportdemo.repository.RouteRepository;
import com.serhat.transportdemo.repository.VehicleRepository;
import com.serhat.transportdemo.service.RouteService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;
    private RouteMapper routeMapper;
    private VehicleRepository vehicleRepository;


    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper, VehicleRepository vehicleRepository) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public RouteDto createRoute(RouteDto routeDto) {

        Route route = routeMapper.mapToEntity(routeDto);
        Route newRoute = routeRepository.save(route);

        RouteDto routeResponse = routeMapper.mapToDTO(newRoute);
        return routeResponse;
    }

    @Override
    public RouteDto getRouteById(long id) {

        Route route = routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route","id",id));
        return routeMapper.mapToDTO(route);
    }
    @Override
    public List<RouteDto> getAllRoutes() {
        return routeRepository.findAll().stream()
                .map(route -> routeMapper.mapToDTO(route))
                .collect(Collectors.toList());

    }
    @Override
    public RouteDto updateRoute(RouteDto routeDto, long id) {
        Route route = routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route","id",id));
         route.setDestination(routeDto.getDestination());
         route.setSource(routeDto.getSource());

        Route updatedRoute = routeRepository.save(route);
        return routeMapper.mapToDTO(updatedRoute);

    }

    @Override
    public void deleteRoute(long id) {
        Route route = routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route","id",id));
         routeRepository.delete(route);
    }
}
