package com.Car.exception;

public class NegativeArgException extends RuntimeException{
 
	public NegativeArgException() {}
	
	public NegativeArgException(String msg) {
		super(msg);
	}
}
