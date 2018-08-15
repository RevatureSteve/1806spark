package com.ex.exceptions;

public class ExceptionsExample {

	/*
	 * IQ: What is the difference between error and exceptions?
	 * 			Error: Errors can happen at runtime or compile time
	 * 			Exceptions: Exceptions only happen at runtime
	 * 
	 * 		So...then what is the difference between a runtime error and exception?
	 * 		
	 * 		Exceptions: recoverable disrupt in the flow of execution
	 * 		Error (runtime): fatal disrupt in the flow of execution
	 * 			e.g. of runtime errors:
	 * 					- OutOfMemoryError: created to many objects no room left
	 * 					- StackOverflowError: too many plates (methods) on the stack...the stack tips over
	 * 
	 * 		How do I recover from an exception?
	 * 			you handle it...aka catch it
	 * 			use the: try/catch blocks
	 * 
	 * 		If an exception is thrown and I don't catch it, does the code after the execution still run?
	 * 			NO! You must catch it to continue executing
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("Exceptions...");
		
		int x = 0;
		
		try {
//			risky code? (code that may throw an exception)
//			surround in a try/catch
			System.out.println(10/x);
		} catch(ArithmeticException e) {
			e.printStackTrace();  // not required but helpful information for the developer to debug
		}
		System.out.println("After exception");
	}

}