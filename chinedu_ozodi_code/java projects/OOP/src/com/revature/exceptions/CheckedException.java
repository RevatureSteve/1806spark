package com.revature.exceptions;

public class CheckedException extends Exception {

	public CheckedException() {
	}

	public CheckedException(String arg0) {
		super(arg0);
	}

	public CheckedException(Throwable arg0) {
		super(arg0);
	}

	public CheckedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public CheckedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
