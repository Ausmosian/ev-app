package com.EV.ChargingStation.controller;

import com.EV.ChargingStation.dto.StationDTO;
import com.EV.ChargingStation.model.Station;
import com.EV.ChargingStation.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/station")
public class StationController {
    @Autowired
    private StationService stationService; //Why/not Autowired

    @GetMapping(value = "/test", produces = "application/json")
    public @ResponseBody String test() {
        return "Hello World!";
    }

    @GetMapping(value = "/", produces = "application/json")
    public @ResponseBody List<Station> getAllStation() {
        return stationService.findAllStation();
    }

    @GetMapping(value = "/show/{stationId}", produces = "application/json")
    public @ResponseBody Optional<Station> getStation(@PathVariable Long stationId) {
        System.out.println(stationId);
        return stationService.findStationById(stationId);
    }

   @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addStation(@ModelAttribute StationDTO station) throws IOException {
        stationService.addStation(station);
   }

   @DeleteMapping(value = "/delete/{id}")
    public void deleteStation(@PathVariable Long id) {
        stationService.deleteStationById(id);
   }

    @PutMapping(value = "/{id}/edit", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void editStation(@PathVariable Long id, @ModelAttribute StationDTO newStation) throws IOException {
        stationService.editStation(id, newStation);
    }
}
