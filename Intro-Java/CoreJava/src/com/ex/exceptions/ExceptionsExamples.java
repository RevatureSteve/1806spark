package com.ex.exceptions;

public class ExceptionsExamples {
	
	/*
	 * IQ: what is the difference between error and exception?
	 * 		error: error can happen at runtime or compile time
	 * 			runtime
	 * 			compilation
	 * 		exception: exceptions only happen at runtime
	 * 
	 * 		what is the difference between a runtime error and an exception?
	 * 
	 * 		exceptions: recoverable disrupt in the flow of execution 
	 * 		error (runtime): fatal disrupt in the flow of execution
	 * 			e.g. of runtime errors:
	 * 				-outOfMemoryError: created too many objects no room left
	 * 				-stackOverflowError: too many plates (methods) on the stack and the stack tips over
	 * 
	 * 		if an exception is thrown and I don't catch it, does the code after the exception still run?
	 * 			no, must catch it to continue excecuting 
	 */

	public static void main(String[] args) {
		System.out.println("Exceptions. .");
		
		int x = 0;
		
		try {
			//risky code (code that may throw an exception)
			//use a try/catch
			System.out.println(10/x);
		} catch(ArithmeticException e) {
			e.printStackTrace(); //not required but help info for the dev to debug 
		}
		
/*		if(true) {
			new Object();
			x++;
			System.out.println(x);
		}*/

	}

}
