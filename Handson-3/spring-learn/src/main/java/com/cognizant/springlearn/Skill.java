package com.cognizant.springlearn;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;

public class Skill {

	@NonNull
	@NumberFormat
	private int id;
	@NonNull
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}
	
}


