package com.library.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({ @PropertySource("application-schedule.properties") })
@ComponentScan(basePackages = "com.library")
public class ScheduleApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleApplication.class, args);
	}

}
