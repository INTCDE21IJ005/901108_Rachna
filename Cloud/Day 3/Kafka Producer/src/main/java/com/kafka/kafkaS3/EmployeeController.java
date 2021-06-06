package com.kafka.kafkaS3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/employees")

public class EmployeeController {

	@Autowired
	private KafkaTemplate<String,Employee> kafkaTemplate;
	
	@Autowired 
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		kafkaTemplate.send("first-topic",employeeRepository.findById(id).get());
		return employeeRepository.findById(id).get();
	}
}

