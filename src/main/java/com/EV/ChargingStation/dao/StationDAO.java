package com.EV.ChargingStation.dao;

import com.EV.ChargingStation.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationDAO extends JpaRepository<Station, Long> {
}
