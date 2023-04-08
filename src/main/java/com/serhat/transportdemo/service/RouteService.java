package com.serhat.transportdemo.service;

import com.serhat.transportdemo.dto.RouteDto;

import java.util.List;

public interface RouteService {
    RouteDto createRoute(RouteDto routeDto);

    RouteDto getRouteById(long id);

    RouteDto updateRoute(RouteDto routeDto, long id);

    void deleteRoute(long id);

    List<RouteDto> getAllRoutes();
}
