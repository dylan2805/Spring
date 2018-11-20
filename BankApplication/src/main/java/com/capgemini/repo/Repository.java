package com.capgemini.repo;

import java.util.Map;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountNumberException;

public class Repository implements RepositoryInter
{
	private Map <String, Customer> customers;
	
	public Repository (Map <String, Customer> customers)
    {
	    this.customers = customers;
    }

	public Customer save(Customer customer) throws InsufficientOpeningBalance, InvalidAccountNumberException{
			
		if (customer.getAccountNumber () == null) throw new InvalidAccountNumberException ("Account Number cannot be null");	
		if (!customer.getAccountNumber ().matches ("[0-9]+")) throw new InvalidAccountNumberException ("Mobile should only contain numbers");
		
		if (customer.getAmount () < 0) throw new InsufficientOpeningBalance ("Balance cannot be negative");
		
		customers.put (customer.getAccountNumber (), customer);
		return customer;
	}

	public Customer findByAccountNumber(String accountNumber) throws InvalidAccountNumberException, InsufficientBalanceException {
		if (accountNumber == null) throw new InvalidAccountNumberException ("accountNumber cannot be null");
		
		Customer customer = customers.get (accountNumber);
		if (customer == null) throw new InvalidAccountNumberException ("Account number " + accountNumber + " not found");
		
		return customer;
	}
	
	public Customer update (Customer customer) throws InvalidAccountNumberException, InsufficientOpeningBalance
	{
		save (customer);
		return customer;
	}
	
}
