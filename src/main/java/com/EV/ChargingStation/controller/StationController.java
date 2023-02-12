package com.EV.ChargingStation.controller;

import com.EV.ChargingStation.model.Station;
import com.EV.ChargingStation.service.StationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/station")
public class StationController {

    private StationService stationService; //Why/not Autowired

    @GetMapping(value = "/test", produces = "application/json")
    public @ResponseBody String test() {
        return "Hello World!";
    }

    @GetMapping(value = "/show/{id}", produces = "application/json")
    public @ResponseBody Optional<Station> getStation(@PathVariable Long stationId) {
        return stationService.findStationById(stationId);
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Station> addStation(@RequestBody Station newStation) {
        return new ResponseEntity<>(stationService.addStation(newStation), HttpStatus.CREATED);
    }
}
