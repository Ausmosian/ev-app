package com.EV.ChargingStation.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class StationDTO {
    private String stationName;
    private int stationPricing;
    private String stationAddress;
    private MultipartFile stationImage;
}
