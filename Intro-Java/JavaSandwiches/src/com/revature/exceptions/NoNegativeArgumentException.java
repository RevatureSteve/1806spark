package com.revature.exceptions;

/*
 * 	Custom exception to make sure the developer clearly
 * 		knows to check the userInput for negative numbers!
 * 		
 * 	2 choices to extends Exception or RuntimeException
 * 		Exception -checked, the developer must handle with try/catch for the time the code doesn't work
 * 		RuntimeException - unchecked, the developer needs to code around the issue NOT use try/catch
 * 
 */
public class NoNegativeArgumentException extends RuntimeException {

	
	public NoNegativeArgumentException() {
	}
	public NoNegativeArgumentException(String message) {
		super(message);
	}

}
