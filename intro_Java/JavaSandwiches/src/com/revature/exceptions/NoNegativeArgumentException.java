package com.revature.exceptions;

/*
 * Custom exception to make sure the developer clearly knows to check the userInput for negative numbers
 * 
 * 2 choices to extends exception or runtime exception
 * Exception checked, the developer must handle with try/catch for the time the code doesn't work
 * Runtime exception- unchecked, the developer needs to code around the issue not use try catch
 */

public class NoNegativeArgumentException extends RuntimeException{

	public NoNegativeArgumentException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NoNegativeArgumentException() {
		// TODO Auto-generated constructor stub
	}
	
	

}
