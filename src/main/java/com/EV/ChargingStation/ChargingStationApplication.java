package com.EV.ChargingStation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication
public class ChargingStationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChargingStationApplication.class, args);
	}

}
