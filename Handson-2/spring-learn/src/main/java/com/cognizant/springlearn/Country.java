package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Country {
	private String code;
	private String name;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	public Country()
	{
		LOGGER.debug("country constructor");
	}

	
	public String getCode() {
		LOGGER.debug("getting code ");
		return code;
	}

	public void setCode(String code) {
		this.code = code;
		LOGGER.debug("setting code");
	}

	public String getName() {
		LOGGER.debug("getting name");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		LOGGER.debug("setting name");
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
