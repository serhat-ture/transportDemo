package com.serhat.transportdemo.dto;

import com.serhat.transportdemo.entity.Station;
import com.serhat.transportdemo.entity.Vehicle;
import lombok.Data;

import java.util.Set;
@Data
public class RouteDto {
    private Long id;
    private String name;
    private String source;
    private String destination;
  // private Set<Station> stations;
  //  private Set<Vehicle> vehicles ;
}
