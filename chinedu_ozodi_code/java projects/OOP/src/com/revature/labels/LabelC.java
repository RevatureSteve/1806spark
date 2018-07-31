package com.revature.labels;

import com.revature.exceptions.CheckedException;
import com.revature.exceptions.UncheckedException;
import com.revature.interfaces.InterfaceA;

public class LabelC extends LabelA implements InterfaceA {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int intC;
	private String stringC;
	
	public LabelC() {
		System.out.println("LabelC created");
	}	
	
	public LabelC(int baseInt, String baseString, int intC, String stringC) {
		super(baseInt, baseString);
		this.intC = intC;
		this.stringC = stringC;
		System.out.println("LabelC with parameters created");
	}

	@Override
	public void useInterface(InterfaceA interfaceA) {
		System.out.println(interfaceA + " has been used");
	}



	@Override
	public void abstractMethod() {
		System.out.println("Abstract method called in LabelC");
		
	}

	public int getIntC() {
		return intC;
	}
	
	
	
	public void setIntC(int intC) {
		if (intC < 0) {
			throw new UncheckedException();
		}
		else {
			this.intC = intC;
		}
	}
	
	
	
	public String getStringC() {
		return stringC;
	}
	
	public void setStringC(String stringC) throws CheckedException {
		if (stringC == null) {
			throw new CheckedException();
		}
		else {			
			this.stringC = stringC;
		}
	}

	@Override
	public String toString() {
		return "LabelC [intC=" + intC + ", stringC=" + stringC + ", getBaseInt()=" + getBaseInt() + ", getBaseString()="
				+ getBaseString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
