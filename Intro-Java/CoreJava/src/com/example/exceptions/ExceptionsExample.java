package com.example.exceptions;

public class ExceptionsExample {

	/*
	 * Errors:Can happen at run time or compile time. 
	 * 	Two types of error
	 * 		runtime
	 * 		compile time
	 * Exceptions: Only happen at run tie.
	 * 
	 * 
	 * so.. then what is the difference between a run time error and exception?
	 * 		
	 * 	Exceptions: Recoverable disrupt in the flow of execution.
	 * 	Error (runtime) Fatal disrupt in the flow of execution.
	 * 
	 * 	e.g of runtime errors
	 * 		Out of Memory err  Creating too many objects.
	 * 		StackOverfloww err Too many plates(methods) on the stack. (Developer error).
	 * 
	 * 
	 * How do I recover from an exception??
	 * 		you handle it....catch it.
	 * 		Use the try/catch blocks.
	 * 
	 * if an exception is thrown and I don't catch it, does the code after the exception still run?
	 * 		No You must catch it to continue executing. 
	 */
	public static void main(String[] args) {
		System.out.println("Exceptions");
		int x = 0;
		
		try {
			//Risky code: Code that may throw an exception.
			System.out.println(10 / x);
		}catch(ArithmeticException e) {
			e.printStackTrace();  //Tracing every stack that lead me to here. Helps the developer see what causes the issue
		}
		
		System.out.println("Other exception");
		
	}

}
