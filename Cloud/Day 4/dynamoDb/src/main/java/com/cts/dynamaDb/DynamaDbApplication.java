package com.cts.dynamaDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class DynamaDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamaDbApplication.class, args);
	}

}
