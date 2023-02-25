package com.EV.ChargingStation.service.impl;

import com.EV.ChargingStation.dao.StationDAO;
import com.EV.ChargingStation.dto.StationDTO;
import com.EV.ChargingStation.model.Station;
import com.EV.ChargingStation.service.FileService;
import com.EV.ChargingStation.service.StationService;
import com.EV.ChargingStation.util.FileUtility;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StationServiceImpl implements StationService {
    @Autowired
    private StationDAO stationDAO;

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public Optional<Station> findStationById(Long stationId) {
        return stationDAO.findById(stationId);
    }

    @Override
    public List<Station> findAllStation() {
        return stationDAO.findAll();
    }

    @Override
    public void addStation(StationDTO stationDTO) throws IOException {
        String imageName = FileUtility.saveImage(path, stationDTO.getStationImage());
        Station station = new Station();
        station = modelMapper.map(stationDTO, Station.class);

        String fullImagePath = path + imageName;
        station.setStationImage(fullImagePath);
        stationDAO.save(station);
    }

    @Override
    public void deleteStationById(Long id) {
        stationDAO.deleteById(id);
    }

    @Override
    public void editStation(Long id, StationDTO newStationDTO) {
        Station oldStation = stationDAO.findById(id).get();

        modelMapper.map(newStationDTO, oldStation);
        stationDAO.save(oldStation);
    }


}
