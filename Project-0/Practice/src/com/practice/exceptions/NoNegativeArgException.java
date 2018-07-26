package com.practice.exceptions;

public class NoNegativeArgException extends RuntimeException {

	
	public NoNegativeArgException() {
		
	}
	public NoNegativeArgException(String msg) {
		super(msg);
	}
}
