package com.ex.exception;

public class ExceptionsExample {
	
	/*
	 * IQ: What is the difference between error and exceptions?
	 * 		Error: Errors can happen at runtime or compile time
	 * 			2 types of errors:
	 * 				runtime compilation time
	 * 				compilation
	 * 		Exception: Exceptions only happen at runtime!
	 * 
	 * 		So..then what is the difference between a runtime error and exception?
	 * 
	 * 		Exceptions: recoverable disrupt in the flow of execution
	 * 		Error (runtime): fatal disrupt in the flow of execution
	 *			e.g. of runtime errors:
	 *				-OutOfmemoryError: created too many objects
	 *				-StackOverflowError: too many plates (methods) on the stack...the stack tips over
	 */
	
	public static void main(String[] args) {
		System.out.println("Exceptions..");
		
		int x = 0;
		
		try {
			// risky code? (code that may throw an exception
			// surround in a try/catch
			System.out.println(10/x);
		}catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}

}
