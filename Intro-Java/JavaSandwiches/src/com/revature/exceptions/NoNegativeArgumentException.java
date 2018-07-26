package com.revature.exceptions;

/*
<<<<<<< HEAD
 * Custom exception to make sure the developer clearly knows
 * to check the userInput for negative numbers.
 * 
 * 2 choices to extend Exception or RuntimeException.
 *  Exception - checked, developer must handle with try/catch for the time code doesnt work.
 *  RunTimeException - unchecked, developer needs to code around the issue NOT use try/catch.
 * */

=======
 * 	Custom exception to make sure the developer clearly
 * 		knows to check the userInput for negative numbers!
 * 		
 * 	2 choices to extends Exception or RuntimeException
 * 		Exception -checked, the developer must handle with try/catch for the time the code doesn't work
 * 		RuntimeException - unchecked, the developer needs to code around the issue NOT use try/catch
 * 
 */
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
public class NoNegativeArgumentException extends RuntimeException {

	
	public NoNegativeArgumentException() {
	}
	public NoNegativeArgumentException(String message) {
		super(message);
<<<<<<< HEAD
		
	}
	
	
	
=======
	}

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
