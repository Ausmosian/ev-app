package com.EV.ChargingStation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "station_id", nullable = false)
    private Long stationId;

    private String stationName;
    //TODO : stationImage
    private int stationPricing;
    private String stationAddress;

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public int getStationPricing() {
        return stationPricing;
    }

    public void setStationPricing(int stationPricing) {
        this.stationPricing = stationPricing;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }
}
