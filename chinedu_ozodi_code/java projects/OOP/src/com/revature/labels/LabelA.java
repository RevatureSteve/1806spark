package com.revature.labels;

import java.io.Serializable;

import com.revature.interfaces.InterfaceA;

public abstract class LabelA implements InterfaceA, Serializable {
	/**
	 * Used to track changes to the class
	 */
	private static final long serialVersionUID = 1L;
	private int baseInt;
	private String baseString;

	public LabelA() {
		super();
	}
	
	public LabelA(int intA, String stringA) {
		super();
		this.baseInt = intA;
		this.baseString = stringA;
	}
	
	public abstract void abstractMethod();

	public int getBaseInt() {
		return baseInt;
	}

	public void setBaseInt(int baseInt) {
		this.baseInt = baseInt;
	}

	public String getBaseString() {
		return baseString;
	}

	public void setBaseString(String baseString) {
		this.baseString = baseString;
	}
	
}
