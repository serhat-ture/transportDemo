package com.serhat.transportdemo.controller;

import com.serhat.transportdemo.dto.StationDto;

import com.serhat.transportdemo.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/station")
public class StationController {

    private StationService stationService;

    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/all")
    public ResponseEntity getAllStations() {
        List<StationDto> allStation = stationService.getAllStations();
        return ResponseEntity.ok(allStation);
    }

    @GetMapping("/{id}")
    public ResponseEntity getStationById(@PathVariable("id") Long id) {
        StationDto stationb = stationService.getStationById(id);
        return ResponseEntity.status(HttpStatus.OK).body(stationb);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity createNewStation(@RequestBody StationDto stationDto) {
        StationDto respStation = stationService.createStation(stationDto);
        if (respStation == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Station could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respStation);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete")
    public ResponseEntity deleteStation(@RequestParam(name = "id") Long id) {
        stationService.deleteStation(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Station is deleted successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity updateStation(
            @RequestBody StationDto stationDto,
            @PathVariable(name = "id") long id) {
        StationDto updateStation = stationService.updateStation(id, stationDto);

        return ResponseEntity.status(HttpStatus.OK).body(updateStation);


    }


}
