package com.example.timesheetserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TimesheetServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetServerApplication.class, args);
	}

}
