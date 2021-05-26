package com.cognizant.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@GetMapping("/{number}")
	public Loan getLoanByNumber(@PathVariable String number) {
		return new Loan(number,"Car",400000,246,150);
	}
}
