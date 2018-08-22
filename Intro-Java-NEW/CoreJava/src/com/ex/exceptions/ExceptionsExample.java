package com.ex.exceptions;

public class ExceptionsExample {

	/*
	 * ID: What is the difference between error and exception?
	 *  Error: Errors can
	 * happen at runtime or compile time 
	 * Exception: Exceptions only happen at
	 * runtime!
	 * 
	 * what is the difference between a runtime error and exception? 
	 * Exceptions:
	 * recoverable disrupt in the flow of execution 
	 * Error (runtime): fatal disrupt
	 * in the flow of execution ex) 
	 * out of memory error: created too many objects
	 * 
	 * How do you recover from an exception? you catch it.
	 * 
	 * Parent of error and class: Throwable Class. anything that is throwable can be caught, catching errors wont help anything though
	 * 
	 * 
	 * 2 types of exceptions:
	 */
	public static void main(String[] args) {
		System.out.println("Exceptions");
		int x = 0;
		
		try {
			// risky code? (code that might throw an exception)
			// surround in a try catch block
		System.out.println(10/x);
		} catch(ArithmeticException e) {
			e.printStackTrace(); //not required but helpful for the developer to debug
		}
		
		System.out.println("After exception");
	}

}
