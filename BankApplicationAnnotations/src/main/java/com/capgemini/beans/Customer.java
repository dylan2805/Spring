package com.capgemini.beans;

//import java.util.HashMap;

public class Customer {
	
	private String accountNumber;
	private String name;
	private double amount;
	
	public Customer(String name, String accountNumber, double amount) {
		System.out.println("Customer with 3 parameters");
		this.accountNumber = accountNumber;
		this.name = name;
		this.amount = amount;
	}
	public Customer() {
		System.out.println("zero arg customer constructor");
		
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
