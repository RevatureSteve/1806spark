package com.revature.exceptions;

import java.lang.RuntimeException;

public class WrongInputException extends RuntimeException{

	public WrongInputException() {
		super();
	}
	
	public WrongInputException(String message) {
		super(message);
	}
	
}
