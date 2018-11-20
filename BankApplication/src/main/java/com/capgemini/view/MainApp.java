package com.capgemini.view;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repo.Repository;
import com.capgemini.service.Service;

public class MainApp {

	public static void main(String[] args)
			throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Service service = applicationContext.getBean(Service.class);

		Customer customer1 = applicationContext.getBean("customer1", Customer.class);
		System.out.println(customer1.getName());
		System.out.println(customer1.getAccountNumber());
		System.out.println(customer1.getAmount());
		Customer customer2 = applicationContext.getBean("customer2", Customer.class);
		System.out.println(customer2.getName());
		System.out.println(customer2.getAccountNumber());
		System.out.println(customer2.getAmount());

		/*Customer accountCollections = applicationContext.getBean("map", Customer.class);
		Map<String, Customer> accounts = accountCollections.getAccounts();
		System.out.println(accounts.get("1").getAccountNumber());
		System.out.println(accounts.get("1").getName());
		System.out.println(accounts.get("1").getAmount());*/

		// Deposit 3000 into acc 2
		System.out.println (service.makeDeposit("2", 3000));
		
		// Withdraw 1000 from acc 1
		System.out.println (service. withdrawAmount("1", 1000));
		
		//Transfer 400 from acc1 to acc2
		System.out.println (service.transferFunds ("1", "2", 400));

	}

}
