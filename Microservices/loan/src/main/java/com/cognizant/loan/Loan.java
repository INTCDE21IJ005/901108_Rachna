package com.cognizant.loan;

public class Loan {
	public String number;
	public String type;
	public long loan;
	public double emi;
	public int tenure;
	public Loan(String number, String type, long loan, double emi, int tenure) {
		super();
		this.number = number;
		this.type = type;
		this.loan = loan;
		this.emi = emi;
		this.tenure = tenure;
	}
	@Override
	public String toString() {
		return "Loan [number=" + number + ", type=" + type + ", loan=" + loan + ", emi=" + emi + ", tenure=" + tenure
				+ "]";
	}

}
