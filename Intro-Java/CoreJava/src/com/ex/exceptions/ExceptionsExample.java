package com.ex.exceptions;

public class ExceptionsExample {
	
	/*
	 *		Exceptions: recoverable disrupt in the flow of execution
	 *		Error (runtime): fatal disrupt in the flow of execution
	 *			e.g., OutOfMemoryError: created too many objects, no room left
	 *				StackOverflowError: too many plates (methods) on the stack
	 *
	 *		How do I recover from an exception?
	 *			you handle it...aka catch it
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Exceptions..");
		int x = 0;
		
		try {
			// surrounds risky code, code that may throw an exception
			System.out.println(10/x);
		} catch(ArithmeticException e) {
			e.printStackTrace();  // gives helpful info for the dev to debug
		}
		
	}

}
