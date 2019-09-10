package com.library.bussiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import com.library.dao.DaoApplication;

@SpringBootApplication
@PropertySources({ @PropertySource("application-bussiness.properties") })
@Import(DaoApplication.class)
public class BussinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(BussinessApplication.class, args);
	}

}
