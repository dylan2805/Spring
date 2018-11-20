package com.capgemini.beans;

//import java.util.HashMap;

public class Customer {
	
	private String accountNumber;
	private String name;
	private double amount;
/*	private HashMap<String, Customer> accounts;
	
	public HashMap<String, Customer> getAccounts() {
		return accounts;
	}
	public void setAccounts(HashMap<String, Customer> accounts) {
		this.accounts = accounts;
	}*/
	
	public Customer(String accountNumber, String name, double amount) {
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
