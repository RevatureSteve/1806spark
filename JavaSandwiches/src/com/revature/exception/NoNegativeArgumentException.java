package com.revature.exception;


/*
 * custom exception to make sure the dev clearly knows the check the input for negative numbers
 * 
 * 2 choices to extends Exception or runtimeException
 * 		exception - checked, the dev must handle w/ a try/catch for the time the code doesn't work
 * 		runtimeException -unchecked, the dev needs to code around the issue and NOT use try/catch
 */
public class NoNegativeArgumentException extends Exception {// the error occurs b/c I got rid of Runtime

	public NoNegativeArgumentException() {
		// needed always
	}
	
	public NoNegativeArgumentException(String message) {
		super(message);
	}
	

}
