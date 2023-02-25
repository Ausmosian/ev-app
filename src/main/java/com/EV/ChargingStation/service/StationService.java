package com.EV.ChargingStation.service;

import com.EV.ChargingStation.dto.StationDTO;
import com.EV.ChargingStation.model.Station;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public interface StationService {

    Optional<Station> findStationById(Long stationId);

    List<Station> findAllStation();

    void addStation(StationDTO stationDTO) throws IOException;

    void deleteStationById(Long id);

    void editStation(Long id, StationDTO newStation);
}
