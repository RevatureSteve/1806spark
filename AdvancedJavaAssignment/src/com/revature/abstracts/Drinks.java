package com.revature.abstracts;

import com.revature.exceptions.EmptyStringException;
import com.revature.exceptions.NoNegativeException;

public abstract class Drinks {

	private String brandName;
	private int ounces;

	
	
	public Drinks() {
		super();
	}
	
	public Drinks(String brandName, int ounces) {
		super();
		this.brandName = brandName;
		this.ounces = ounces;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	
	public int getOunces() {
		return ounces;
	}

	public void setOunces(int ounces) throws NoNegativeException{
		if (ounces < 0) {
			System.out.println("Please don't put negative numbers.  Here, we'll default the value to 12");
			this.ounces = 12;
			throw new NoNegativeException();
		}
		this.ounces = ounces;
	}

	/**
	 * Don't allow for an empty string
	 * @param name
	 * @throws EmptyStringException
	 */
	public void setBrandName(String brandName) throws EmptyStringException {
		if (brandName == "") {
			System.out.println("I'm sorry, you can't do that");
			throw new EmptyStringException();
		}else {
			this.brandName = brandName;
		}
	}
	
	
	/**
	 * print out where attraction is located
	 */
	public void whatDrink() {
		System.out.println(brandName + " is " + ounces + " ounces");
	}
	
	
	public abstract void printDrinkInfo();
	
	
	
	
	
}
