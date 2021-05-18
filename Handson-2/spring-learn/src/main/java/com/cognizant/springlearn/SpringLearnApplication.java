package com.cognizant.springlearn;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@ComponentScan(basePackages="com")
@SpringBootApplication
public class SpringLearnApplication {	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		
	}
	
	public Country displayCountry() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("india.xml"); 
		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}
	 
	public List<Country> displayCountries()
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		ArrayList<Country> list=context.getBean("countryList",java.util.ArrayList.class);
		return list;
		
	}

}
