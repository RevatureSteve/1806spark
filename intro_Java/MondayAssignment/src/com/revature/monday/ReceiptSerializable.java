package com.revature.monday;

import java.io.Serializable;

public class ReceiptSerializable implements Serializable {
	
////	 * Student Class is a JavaBean- a stricter version of a POJO
//	 * 
//	 * 	1. State must be fully encapsulated
//	 *  2. Provide Getters and setter where needed
//	 *  3. must have a no-args constructor
//	 *  4. class must implements Serializable
//	 *  5. override toString()
	
	private static final long serialVersionUID = 11;
	
	
	
	private double checkTotal;
	private transient int creditCardNumber;
	
	public ReceiptSerializable() {}
	
	public ReceiptSerializable( double yourCheckcheckTotal, int yourCheckcreditCardNumber) {}
	 
	

	public double getCheckTotal() {
		return checkTotal;
	}

	public void setCheckTotal(double checkTotal) {
		this.checkTotal = checkTotal;
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public String toString() {
		return "ReceiptSerializable [checkTotal=" + checkTotal + ", creditCardNumber=" + creditCardNumber + "]";
	}

	
	
	
	
	

}
