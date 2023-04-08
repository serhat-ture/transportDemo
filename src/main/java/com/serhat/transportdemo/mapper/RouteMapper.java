package com.serhat.transportdemo.mapper;

import com.serhat.transportdemo.dto.RouteDto;
import com.serhat.transportdemo.entity.Route;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    @Autowired
    private ModelMapper modelMapper;


    // convert Entity into DTO
    public RouteDto mapToDTO(Route route) {
        RouteDto routeDto = modelMapper.map(route, RouteDto.class);
        return routeDto;
    }

    // convert DTO to entity
    public Route mapToEntity(RouteDto routeDto) {
        Route route = modelMapper.map(routeDto, Route.class);
        return route;
    }
}
