package com.revature.exception;
/*
 * using this for when nothing is entered into the FrontJobTitle
 */
@SuppressWarnings("serial")
public class NoEmptyString extends RuntimeException {
	
	public NoEmptyString() {}
	
	public NoEmptyString(String message) {
		super(message);
		
	}

}
