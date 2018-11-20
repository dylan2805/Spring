package com.capgemini.exceptions;

public class InsufficientOpeningBalance extends Exception {
	
	private static final long serialVersionUID = -4212896790055413234L;

	public InsufficientOpeningBalance (String message)
	{
		super (message);
	}
}
