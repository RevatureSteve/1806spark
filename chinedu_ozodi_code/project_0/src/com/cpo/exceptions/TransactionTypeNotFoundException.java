package com.cpo.exceptions;

public class TransactionTypeNotFoundException extends RuntimeException {

	public TransactionTypeNotFoundException() {
	}

	public TransactionTypeNotFoundException(String arg0) {
		super(arg0);
	}

	public TransactionTypeNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public TransactionTypeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public TransactionTypeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
