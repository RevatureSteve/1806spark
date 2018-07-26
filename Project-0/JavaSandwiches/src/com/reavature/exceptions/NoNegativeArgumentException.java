package com.reavature.exceptions;
/*
 * custom exception to make sure the dev clearly knows to check the userInput for negative numbers!
 * 
 * 2 choices to extend exception or RuntimeException
 * exception -checked, the dev must handle with try/catch for the time the code does not work
 * RuntimeException - unchecked, the dev needs to code around the issue NOT use try/catch
 * 
 */

public class NoNegativeArgumentException extends RuntimeException {

	public NoNegativeArgumentException(String message) {
		super(message);
	}
	public NoNegativeArgumentException() {
		super();
	}
	
	

}
