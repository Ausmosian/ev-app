package com.EV.ChargingStation.controller;

import com.EV.ChargingStation.dto.FileDTO;
import com.EV.ChargingStation.dto.StationDTO;
import com.EV.ChargingStation.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/image")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<FileDTO> imageUpload(@RequestParam("image") MultipartFile image, @RequestBody StationDTO stationDto) {
        System.out.println(stationDto.toString());
        String fileName = "AfCN";
        return new ResponseEntity<>(new FileDTO(fileName, "Image successfully uploaded"), HttpStatus.OK);
    }
}
