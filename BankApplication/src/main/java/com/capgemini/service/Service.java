package com.capgemini.service;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.repo.RepositoryInter;

public class Service implements ServiceInter
{
	private RepositoryInter repository;
	
	public Service (RepositoryInter repository)
    {
	    this.repository = repository;
    }

	public Customer createAccount(String name, String accountNumber, double amount) throws InsufficientOpeningBalance, InvalidNameException, InvalidAccountNumberException {
		if (name == null) throw new InvalidNameException ("Name cannot be null");
		if (!name.matches ("[a-zA-Z ]+")) throw new InvalidNameException ("Name should only contain alphabets");
		
		if (accountNumber == null) throw new InvalidAccountNumberException ("Account Number cannot be null");
		if(!accountNumber.matches("[0-9]+")) throw new InvalidAccountNumberException ("Account Number must be number");
		
		if (amount < 0) throw new InsufficientOpeningBalance ("Balance cannot be negative");
		Customer customer = new Customer (name, accountNumber, amount);
		repository.save(customer);
		return customer;
	}
	
	public Customer withdrawAmount(String accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance
	{
		if (accountNumber == null) throw new InvalidAccountNumberException ("Account Number cannot be null");	
		if (!accountNumber.matches ("[0-9]+")) throw new InvalidAccountNumberException ("Account Number should only contain numbers");
		
		if (amount < 0) throw new InsufficientBalanceException ("Amount cannot be negative");
		Customer customer= repository.findByAccountNumber(accountNumber);
		customer.setAmount (customer.getAmount () - amount);
		
		repository.update (customer);
		return customer;
	}
	
	public Customer makeDeposit(String accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance {
		if (accountNumber == null) throw new InvalidAccountNumberException ("Account Number cannot be null");	
		if (!accountNumber.matches ("[0-9]+")) throw new InvalidAccountNumberException ("Account Number should only contain numbers");
		
		if (amount < 0) throw new InsufficientBalanceException ("Amount cannot be negative");
		Customer customer= repository.findByAccountNumber(accountNumber);
		customer.setAmount (customer.getAmount () + amount);
		
		repository.update (customer);
		return customer;
	}
	
	public Customer transferFunds(String from, String to, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance {
		
		if (from == null || to == null) throw new InvalidAccountNumberException ("Account number cannot be null");	
		if (amount < 0) throw new InsufficientBalanceException ("Amount cannot be negative");
		
		if (from.equals (to)) throw new InvalidAccountNumberException ("Cannot transfer fund to yourself");
		if (!from.matches ("[0-9]+") || !to.matches ("[0-9]+")) throw new InvalidAccountNumberException ("Account number should only contain numbers");
		
		Customer fromCustomer = repository.findByAccountNumber (from);
		Customer toCustomer = repository.findByAccountNumber (to);
		
		double fromAcc = fromCustomer.getAmount ();
		double toAcc = toCustomer.getAmount ();
		
		if (fromAcc < amount) throw new InsufficientBalanceException ("Insufficient balance");
		
		fromCustomer.setAmount (fromAcc - amount);
		toCustomer.setAmount (toAcc + amount);
		repository.update (fromCustomer);
		repository.update (toCustomer);
		
		return fromCustomer;
	}
	
}
