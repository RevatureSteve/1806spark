package com.ex.exceptions;

public class ExceptionsExample {

	/*
	 * IQ: 
	 * 	What is the difference between error and exception? 
	 * 		Error: Errors can happen at runtime or compile time 
	 * 				2 types of errors: 
	 * 					-runtime 
	 * 					-compilation
	 * 		Exception: Exceptions only happen at runtime!
	 * 
	 * So...then what is the difference between a runtime error and exception?
	 * 
	 * 		Exceptions: recoverable disrupt in the flow of execution 
	 * 		Error (runtime): fatal disrupt in the flow of execution 
	 * 				e.g. of runtime errors:
	 * 					-OutOfMemoryError: created too many objects no room left 
	 * 					-StackOverflowError: too many plates (methods) on the stack...the stack tips over
	 * 
	 * 		How do I recover from an exception?
	 * 			you handle it...aka catch it
	 * 			use the: try/catch blocks
	 * 
	 * 		If an exception is thrown and I don't catch it, does the code after the exception still run?
	 * 			NO! You must catch it to continue executing
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Exceptions..");
		int x = 0;

		try {
			//risky code?  (code that may throw an exception)
			// surround in a try/catch
			System.out.println(10/x);
		}catch(ArithmeticException e) {
//			e.printStackTrace(); // not required but helpful information for the developer to debug
		}
		
		System.out.println("After exception");
	}

	
	
	
	
	
	
	
//	public static void iCallMySelf() {
//		iCallMySelf(); // recursion - calling yourself to repeat logic
//	}

//	public static int factorial(int n) {
//		if (n == 0)
//			return 1;
//		else
//			return (n * factorial(n - 1));
//	}
//
//	public static void main(String args[]) {
//		int i, fact = 1;
//		int number = 8;// It is the number to calculate factorial
//		fact = factorial(number);
//		System.out.println("Factorial of " + number + " is: " + fact);
//	}
}
