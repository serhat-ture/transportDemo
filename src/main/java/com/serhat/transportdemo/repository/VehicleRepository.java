package com.serhat.transportdemo.repository;


import com.serhat.transportdemo.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByRouteId(long routeId);
}
