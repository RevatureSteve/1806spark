package com.ex.exceptions;

public class ExceptionsExample {

	/*
	 * IQ: What is the difference between error and exception?
	 * 
	 * Error: Errors can happen at runtime or compile time(cannot go from .java to
	 * .class file) 
	 * 2 types of errors... Runtime & Compilation 
	 * Exception: Exceptions only happen at runtime!
	 * 
	 * So then what is the difference between a runtime error and exception
	 * 
	 * Exceptions: Recoverable disrupt in the flow of execution 
	 * Error (runtime): fatal disrupt in the flow of execution 
	 * e.g. (runtime): 
	 * -OutOfMemoryError: Created too many objects 
	 * -stackOverFlowError: Too many method plates on the stack... stack tips over
	 * 
	 * 
	 * How do I recover from an exception
	 * 	-You handle it... aka catch it
	 * - use try/catch
	 */

	public static void main(String[] args) {
		System.out.println("Exceptions..");
		int x = 0;
		
		try { 
		//risky code? (code that may throw an exception)
		// surround in a try/catch block
		System.out.print(10/x);
		
		}
		catch(ArithmeticException e) {
		 e.printStackTrace();//Not required, but helpful to developer to find what cause the issue.
		}
		
		
		System.out.println("After exception");
		
	}
}
