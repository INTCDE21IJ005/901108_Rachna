package com.cognizant.springlearn;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@RequestMapping(method = RequestMethod.GET,value ="/countries")			
	public List<Country> getallCountries(){
		SpringLearnApplication springrest= new SpringLearnApplication();
		return springrest.displayCountries();
	}
	@RequestMapping(method = RequestMethod.GET,value ="/country")			
	public Country getCountryIndia(){
		SpringLearnApplication springrest= new SpringLearnApplication();
		return springrest.displayCountry();
	}
}
