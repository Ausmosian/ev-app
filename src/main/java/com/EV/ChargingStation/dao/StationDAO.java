package com.EV.ChargingStation.dao;

import com.EV.ChargingStation.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationDAO extends JpaRepository<Station, Long> {

}
