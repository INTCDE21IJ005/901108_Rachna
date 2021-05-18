package com.cognizant.springlearn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.springlearn.controller.CountryController;

@SpringBootTest
class SpringLearnApplicationTests {

	@Test
	public void contextLoads() {
	assertNotNull(countryController);
	}
	
	private void assertNotNull(CountryController countryController2) {
		// TODO Auto-generated method stub	
	}

	@Autowired
	private CountryController countryController;
	
	@SuppressWarnings("unused")
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetCountry() throws Exception {
	}
	
	
}
