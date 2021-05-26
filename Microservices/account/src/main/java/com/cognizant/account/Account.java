package com.cognizant.account;

public class Account {
	public String number;
	public String type;
	public long balance;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	public Account(String number, String type, long balance) {
		super();
		this.number=number;
		this.type=type;
		this.balance=balance;
		
	}
	@Override
	public String toString() {
		return "Account [number=" + number + ", type=" + type + ", balance=" + balance + "]";
	}

}
