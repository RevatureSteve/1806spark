package com.revature.labels;

public class LabelE extends LabelC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LabelE() {
		super();
		System.out.println("Empty constructor called for LabelE");
	}

	public LabelE(int baseInt, String baseString, int intC, String stringC) {
		super(baseInt, baseString, intC, stringC);
		System.out.println("Overloaded constructor called for LabelE");
	}	

}
