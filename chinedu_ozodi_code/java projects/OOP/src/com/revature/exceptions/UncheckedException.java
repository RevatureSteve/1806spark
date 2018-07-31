package com.revature.exceptions;

public class UncheckedException extends RuntimeException {

	public UncheckedException() {
	}

	public UncheckedException(String arg0) {
		super(arg0);
	}

	public UncheckedException(Throwable arg0) {
		super(arg0);
	}

	public UncheckedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public UncheckedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
