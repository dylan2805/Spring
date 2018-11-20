package com.capgemini.service;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidNameException;

public interface ServiceInter {
	
	public Customer createAccount (String name, String accountNumber, double amount) throws InsufficientOpeningBalance, InvalidNameException, InvalidAccountNumberException;
	public Customer makeDeposit (String accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance;
	public Customer withdrawAmount (String accountNumber, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance;
	public Customer transferFunds (String from, String to, double amount) throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance;

}
