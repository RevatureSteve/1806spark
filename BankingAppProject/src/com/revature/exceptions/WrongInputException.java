package com.revature.exceptions;

import java.util.InputMismatchException;

public class WrongInputException extends InputMismatchException{

	public WrongInputException() {
		super();
	}
	
	public WrongInputException(String message) {
		super(message);
	}
	
}
