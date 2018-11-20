package com.capgemini.exceptions;

public class InvalidNameException extends Exception {
	
	private static final long serialVersionUID = -5791937823954947926L;

	public InvalidNameException (String message)
    {
		super (message);
    }

}
