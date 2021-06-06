package com.swagger.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"package com.swagger.swagger.AddressBookResource"})
@EnableSwagger2
@ComponentScan
public class AaSwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AaSwaggerApplication.class, args);
	}

}
