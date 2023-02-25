package com.EV.ChargingStation.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id", nullable = false)
    private Long stationId;

    private String stationName;
    private String stationImage;
    private int stationPricing;
    private String stationAddress;

}
