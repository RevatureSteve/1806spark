package com.ex.exceptions;

/*
 * Custom exception
 * 
 * 2 choices:
 * 	exception - checked, the developer must handle with try/catch for the time the code doesn't work.
 * 	RuntimeException - unchecked, the developer needs to code around the issue NOT use try/catch
 */

public class NoNegativeArgumentException extends RuntimeException{
	
	public NoNegativeArgumentException() {}

	public NoNegativeArgumentException(String message) {
		super(message);
	}

}
