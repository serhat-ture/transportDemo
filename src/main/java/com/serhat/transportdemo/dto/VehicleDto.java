package com.serhat.transportdemo.dto;

import com.serhat.transportdemo.entity.Route;
import lombok.Data;

import java.util.Set;

@Data
public class VehicleDto {
    private Long id;
    private String name;
    private String plate;
    private int capacity;
    private Route route;
}
