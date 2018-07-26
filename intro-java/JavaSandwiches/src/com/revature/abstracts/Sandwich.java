package com.revature.abstracts;

import come.revature.exceptions.NoNegativeArgumentException;

/* - general regular two-line comment
 * abstract keyword can be used in 2 locations:
 *           - classes
 *           - methods
 * no such thing s an abstract variable
 */
/**
 * - Java docs Sandwich class is going to be a template for creating subclasses
 * for specific sandwiches We are going to make this class abstract
 * 
 * subclass examples: -club -dagwood -cuban
 */
public abstract class Sandwich {

	// State aka variables
	private int slicesOfBread; // not going to make it protected because I can handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; // protected variable available to:the class,the package, the subclass
	
//	private boolean isToasted;

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwich() {
	}
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
	super();
	this.setSlicesOfBread(slicesOfBread);
	this.meats = meats;
	this.toppings = toppings;
	this.name = name;
	this.size = size;
}

// Behavior
	
	public abstract void prepping();
	
	
	/**
	 * takeBite() decrements the sandwich size by 1
	 * @return current remaining size of sandwich
	 */
	
	public int takeBite() {
		// this. is not required because there is no other size variable in the parameter or in the method
		this.size--;
		return this.size;
	}
	
	public int takeBite(int biteSize) {
		this.size -= biteSize; // same as: this.size = this.size - biteSize;
		return this.size;
	}

	
	/*
	 * creating a getter and setter for the private variable slicesOfBread
	 */
	public int getSlicesOfBread() {
		return slicesOfBread;
		
	}
	/**
	 *  Setting the property int slicesOfBread
	 *      do not pass a negative number as an argument if you do I will set it to 0
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) throws NoNegativeArgumentException {
		if(slicesOfBread < 0) {
			System.out.println("Cannot have a negative value for slicesOfBread, setting it to 0");
			this.slicesOfBread = 0;
			throw new NoNegativeArgumentException();
		}else {
		this.slicesOfBread = slicesOfBread;
		}
		
	}
}
