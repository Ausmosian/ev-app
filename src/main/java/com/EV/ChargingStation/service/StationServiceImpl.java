package com.EV.ChargingStation.service;

import com.EV.ChargingStation.dao.StationDAO;
import com.EV.ChargingStation.model.Station;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {

    private StationDAO stationDAO;
    @Override
    @Transactional
    public Optional<Station> findStationById(Long stationId) {
        return stationDAO.findById(stationId);
    }

    @Override
    public Station addStation(Station newStation) {
        return stationDAO.save(newStation);
    }
}
