package com.revature.labels;

import com.revature.exceptions.CheckedException;
import com.revature.exceptions.UncheckedException;
import com.revature.interfaces.InterfaceA;

public class LabelB extends LabelA implements InterfaceA {
	
	private int intB;
	private String stringB;
	

	public LabelB() {
		System.out.println("LabelB created");
	}
	
	public LabelB(int baseInt, String baseString, int intB, String stringB) {
		super(baseInt, baseString);
		this.intB = intB;
		this.stringB = stringB;
		System.out.println("LabelB with parameters created");
	}

	@Override
	public void useInterface(InterfaceA interfaceA) {
		System.out.println(interfaceA + " has been used");
	}


	@Override
	public void abstractMethod() {
		System.out.println("Abstract method called in LabelB");
		
	}

	public int getIntB() {
		return intB;
	}
	
	
	
	public void setIntB(int intB) {
		if (intB < 0) {
			throw new UncheckedException();
		}
		else {
			this.intB = intB;
		}
	}
	
	
	
	public String getStringB() {
		return stringB;
	}
	
	public void setStringB(String stringB) throws CheckedException {
		if (stringB == null) {
			throw new CheckedException();
		}
		else {			
			this.stringB = stringB;
		}
	}
	
	
	
	
}
