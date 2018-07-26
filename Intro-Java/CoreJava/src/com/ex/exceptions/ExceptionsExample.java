package com.ex.exceptions;

public class ExceptionsExample {
	
	/*
	 * What is the difference between error and exception
	 * Error: Errors can happen at runtime or compile time
	 * 
	 * 		2 types of errors: runtime and compilation 
	 * 
	 * 
	 * Exception: exceptions only happen at runtime!
	 * 
	 * So... then what is the difference between a runtime error and exception?
	 * 
	 * - happen at different times 
	 * 
	 * exceptions: recoverable disrupt in flow of execution
	 * error (runtime): fatal disrupt in the flow of execution 
	 * 		examples of runtime errors:
	 * 			- OutOfMemoryError : created too many objects no room left (could be user error)
	 * 			- StackOverflowError: too many plates (methods) on the stack... the stack tips over (developer error)
	 * 
	 * 
	 * How do I recover from an exception?
	 * 		you handle it... aka catch it
	 * 		use the: try/catch blocks
	 * 
	 * If an exception is thrown and I don't catch it, does the code after the exception still run?
	 * 		No! you must catch it to continue executing
	 */
	
	
//	public static void main(String[] args) {
//		System.out.println("Exceptions..");
//		iCallMySelf();
//	}
//	
//	public static void iCallMySelf() {
//		iCallMySelf(); //recursion - calling yourself to repeat logic
//	}
//	
	
	public static void main(String[] args) {
		System.out.println("Exceptions..");
		int x = 0;
		
		try {
			//risky code? (code that may throw an exception)
			//surround in a try/catch
			System.out.println(10/x);
		}catch(ArithmeticException e) {
			e.printStackTrace();  //not required but helpful information for developer to debug
			//helpful in triage
		}
		System.out.println("After exception");
	}

	

}
