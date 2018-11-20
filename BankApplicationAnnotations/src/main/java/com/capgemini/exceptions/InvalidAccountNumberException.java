package com.capgemini.exceptions;

public class InvalidAccountNumberException extends Exception {
	
	private static final long serialVersionUID = -5791938823954947926L;

	public InvalidAccountNumberException (String message)
    {
		super (message);
    }

}
