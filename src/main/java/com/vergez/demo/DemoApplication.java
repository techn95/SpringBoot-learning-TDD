package com.vergez.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// System.setProperty(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "vergez"); //first methode
		SpringApplication.run(DemoApplication.class, args);
	}

}
