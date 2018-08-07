package com.revature.exceptions;

public class NoEmptyStringException extends Exception{

	public NoEmptyStringException(String message) {
		super(message);
	}

	public NoEmptyStringException() {
		super();
	}
	
}
