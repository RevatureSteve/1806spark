package com.revature.exceptions;

@SuppressWarnings("serial")
public class TooFewLionsException extends Exception {
	private int numberOfLions;
		
	public TooFewLionsException(int numberOfLions) {
		this.numberOfLions = numberOfLions;
		
	}
}