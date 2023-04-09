package com.serhat.transportdemo.dto;

import com.serhat.transportdemo.entity.Route;
import lombok.Data;

import java.util.List;


@Data
public class StationDto {
    private Long id;
    private String name;
    private String location;
    //private List<Route> route;
}
