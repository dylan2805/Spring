package com.capgemini.view;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.beans.Customer;
import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientOpeningBalance;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.exceptions.InvalidNameException;
import com.capgemini.repo.RepositoryImpl;
import com.capgemini.service.ServiceImpl;
import com.capgemini.service.ServiceInter;

public class MainApp {

	public static void main(String[] args)
			throws InvalidAccountNumberException, InsufficientBalanceException, InsufficientOpeningBalance, InvalidNameException {
		
		ApplicationContext context = new AnnotationConfigApplicationContext ();
		
		((AnnotationConfigApplicationContext) context).scan ("com.capgemini");
		((AnnotationConfigApplicationContext) context).refresh ();
		
		ServiceInter service = context.getBean (ServiceImpl.class);

/*		Customer customer1 = applicationContext.getBean("customer1", Customer.class);
		System.out.println(customer1.getName());
		System.out.println(customer1.getAccountNumber());
		System.out.println(customer1.getAmount());
		Customer customer2 = applicationContext.getBean("customer2", Customer.class);
		System.out.println(customer2.getName());
		System.out.println(customer2.getAccountNumber());
		System.out.println(customer2.getAmount());*/


		//create account1
		System.out.println (service.createAccount ("Dylan", "1", 9000));
		
		//create account2
		System.out.println (service.createAccount ("Jaysan", "2", 7000));
		
		// Deposit 3000 into acc 2
		System.out.println (service.makeDeposit("2", 3000));
		
		// Withdraw 1000 from acc 1
		System.out.println (service. withdrawAmount("1", 1000));
		
		//Transfer 400 from acc1 to acc2
		System.out.println (service.transferFunds ("1", "2", 400));

	}

}
