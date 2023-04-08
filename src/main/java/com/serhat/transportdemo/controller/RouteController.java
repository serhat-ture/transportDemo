package com.serhat.transportdemo.controller;

import com.serhat.transportdemo.dto.RouteDto;
import com.serhat.transportdemo.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/route")
public class RouteController {

    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }


    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public ResponseEntity<RouteDto> createRoute(@RequestBody RouteDto routeDto) {
        RouteDto routeResponse = routeService.createRoute(routeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(routeResponse);
    }

    @GetMapping()
    public List<RouteDto> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getRouteById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(routeService.getRouteById(id));
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<RouteDto> updateRoute(@RequestBody RouteDto routeDto, @PathVariable(name = "id") long id) {
        RouteDto routeResponse = routeService.updateRoute(routeDto, id);

        return ResponseEntity.status(HttpStatus.OK).body(routeResponse);

    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoute(@PathVariable(name = "id") Long id) {
        routeService.deleteRoute(id);
        return ResponseEntity.status(HttpStatus.OK).body("Route deleted successfully");

    }




}
