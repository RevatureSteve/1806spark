package com.revature;

public class TooFewArgumentException extends RuntimeException {

	public TooFewArgumentException() {
	}

	public TooFewArgumentException(String message) {
		super(message);
	}

}
