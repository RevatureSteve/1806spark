package com.revature.exceptions;

public class InputMismatchException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InputMismatchException () {
		super();
		System.err.println("Please use numbers!");
}
}
