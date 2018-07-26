package com.ex.exceptions;

public class ExceptionsExamples {
	
	/*
	 * 
	 * IQ: What is the difference between error and exception?
	 * Error: Errors can happen at runtime or compile time
	 * 		2 types of errors:
	 * 			runtime: fatal disrupt in the flow of execution
	 * 				e.g. of runtime errors:
	 * 					-OutOfMemoryError: created too many objects no room left
	 * 					-StackOverflowError: too many plates (methods) on the stack... the stack tips over
	 * 			compilation
	 * Exception: Exceptions only happen at runtime! recoverable disrupt in the flow of execution
	 * 
	 *  So...then what is the difference between runtime error and exception?
	 *  
	 *  	How do I recover from an exception?
	 *  		you handle it...aka catch it
	 *  		use the: try/catch blocks
	 *  
	 *  	If an exception is thrown and I don't catch it, does the code after the exception still run?
	 *  		NO! You must catch it to continue executing
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("Exceptions..");
		int x = 0;
		
		try {
			//risky code? (code that may throw an exception)
			// surround in a try/catch
			System.out.println(10/x);
		} catch (ArithmeticException e) {
			e.printStackTrace(); // not required but help information for the developer to debug
		}
		
		System.out.println("After exception");
	}
	
	public static void iCallMyself() {
		iCallMyself(); // recursion - calling yourself to repeat logic
	}
	
	
	// MOST COMMON EXCEPTION -NullPointerException!
	Object object;

}
