package com.EV.ChargingStation.dto;

import lombok.Data;

@Data
public class FileDTO {

    private String fileName;
    private String message;
    public FileDTO(String fileName, String message) {
        this.fileName = fileName;
        this.message = message;
    }
}
