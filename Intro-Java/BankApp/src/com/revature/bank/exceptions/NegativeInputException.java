package com.revature.bank.exceptions;

public class NegativeInputException extends Exception{
	public NegativeInputException() {
	}

	public NegativeInputException(String message) {
		super(message);
	}
}
