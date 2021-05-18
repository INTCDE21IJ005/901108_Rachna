package com.cognizant.springlearn;

import java.util.Date;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Employee {

	@NonNull
	@NumberFormat
	private int id;
	@NonNull
	
	
	private String name;
	@NonNull

	private double salary;
	@NonNull
	private String permanent;
	@NonNull
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy",timezone = "EST")
	private Date dateOfBirth;
	
	@NonNull
	private Department department;
	@NonNull
	private Skill skill;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPermanent() {
		return permanent;
	}
	public void setPermanent(String permanent) {
		this.permanent = permanent;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", department=" + department + ", skill=" + skill + "]";
	}
	
	
	
}

