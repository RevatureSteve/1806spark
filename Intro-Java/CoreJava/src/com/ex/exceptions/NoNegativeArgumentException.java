package com.ex.exceptions;


/*
 * custom exception to make sure the developer clearly 
 * 	knows to check the user input for negative numbers!
 * 
 * 2 choices to extends exception or runtimeexception
 * 		exception- checked, the developer must handle with try/catch for the time the code doesn't work
 * 		runtime exception unchecked, the developer needs to code around issue not use try/catch
 */
public class NoNegativeArgumentException extends RuntimeException {

	public NoNegativeArgumentException(String message) {
		super(message);
		
	}

	
	public NoNegativeArgumentException() {
		super();
		
	}
	
	
	
	
	
}
