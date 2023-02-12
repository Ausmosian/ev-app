package com.EV.ChargingStation.service;

import com.EV.ChargingStation.model.Station;

import java.util.Optional;

public interface StationService {

    public Optional<Station> findStationById(Long stationId);

    Station addStation(Station newStation);
}
