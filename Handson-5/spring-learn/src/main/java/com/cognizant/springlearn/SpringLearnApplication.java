package com.cognizant.springlearn;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.controller.CountryController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) throws Exception {
		
		LOGGER.info("Main Start");
		SpringApplication.run(SpringLearnApplication.class, args);
		SpringLearnApplication app = new SpringLearnApplication();
		app.displayDate();
		app.displayCountry();
		CountryController countryController = new CountryController();
		countryController.getCountryIndia();
		countryController.addCountry(new Country("UK","United Kingdom"));
		//app.displayCountries();
		LOGGER.info("Main End");
	}
	
	
	public void displayDate() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		Date date = format.parse("31/12/2018");
		LOGGER.info("Start");
		System.out.println(date);
		//LOGGER.debug(date);
		LOGGER.info("End");
	}
	
	public void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		LOGGER.info("Start");
		Country country = (Country) context.getBean("us", Country.class);
		Country anotherCountry = context.getBean("us", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("End");
	}
	
	/*
	public void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		LOGGER.info("Start");
		List<Country> countries = (List<Country>) context.getBean("countryList", Country.class);
		LOGGER.debug("Country : {}", countries);
		LOGGER.info("End");
		
	}
	*/

}
