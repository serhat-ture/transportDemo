package com.serhat.transportdemo.repository;


import com.serhat.transportdemo.dto.StationDto;
import com.serhat.transportdemo.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StationRepository extends JpaRepository<Station, Long> {
    List<StationDto> findAllStation();

}
