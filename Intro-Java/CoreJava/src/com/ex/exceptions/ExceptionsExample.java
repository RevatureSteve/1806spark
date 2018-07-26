package com.ex.exceptions;

public class ExceptionsExample {
	
	/*
	 * IQ: What is the difference between error and exception?
	 * Error: Errors can happen at runtime or compile time
	 * 	2 types of errors:
	 * 				runtime
	 * 				compilation
	 * Exception: Exceptions only happen at runtime!
	 * 
	 * so....then what is the difference between a runtime error and exception?
	 * 
	 * Exceptions: recoverable disrupt in the flow of execution
	 * Error (runtime): fatal disrupt in the flow of execution
	 * e.g of runtime error: 
	 * 				-OutOfMemoryError: created to many objects no room left
	 * 				-StackOverflowError: too many plates on the stack... stack tips over
	 * 
	 * 		How do I recover from an exception?
	 * 			you handle it... aka catch it
	 * 			use the try catch blocks
	 * 
	 * 	if an exception is thrown and I don't catch it, the code after it will not run...
	 */

	public static void main(String[] args) {
		System.out.println("Exceptions...");
		int x = 0;
		
		try {
		
			System.out.println(10/x);
		}catch(ArithmeticException e) {
			e.printStackTrace(); //not required but helpful info for the dev to debug
		}
		System.out.println("After exception");

	}
	
	public static void iCallMySelf() {
		iCallMySelf(); //recursion - calling yourself to repeat logic
	}

}
