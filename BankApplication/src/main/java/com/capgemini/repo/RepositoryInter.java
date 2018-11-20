package com.capgemini.repo;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountNumberException;

public interface RepositoryInter {
	
		public Customer save (Customer customer) throws InsufficientOpeningBalance, InvalidAccountNumberException;
		public Customer findByAccountNumber (String accountNumber) throws InvalidAccountNumberException, InsufficientBalanceException;
		public Customer update (Customer customer) throws InvalidAccountNumberException, InsufficientOpeningBalance;


}
