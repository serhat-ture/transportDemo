package com.serhat.transportdemo.repository;


import com.serhat.transportdemo.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {

}
