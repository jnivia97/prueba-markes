package com.prueba.markers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.prueba.markers.entity")
public class MarkersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarkersApplication.class, args);
	}

}
