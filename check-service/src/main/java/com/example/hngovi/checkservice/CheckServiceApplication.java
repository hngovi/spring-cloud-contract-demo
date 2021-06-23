package com.example.hngovi.checkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
public class CheckServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckServiceApplication.class, args);
	}

}
