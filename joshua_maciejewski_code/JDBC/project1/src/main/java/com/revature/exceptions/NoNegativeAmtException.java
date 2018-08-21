package com.revature.exceptions;

public class NoNegativeAmtException extends RuntimeException {

	public NoNegativeAmtException() {
		super();
	}
	
	public NoNegativeAmtException(String message) {
		super(message);	
	}

}
