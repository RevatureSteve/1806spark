package com.revature.abstracts;

import com.revature.exceptions.NoNegativeArgumentException;

/*
 * 
 * Sandwich class is going to be a template for creating 
 * 		subclasses for specific sandwiches
 * We are going to make this class abstract
 */

/**
 * abstract keyword can be used in 2 locations:
 * 		- classes
 * 		- methods
 * no such thing as an abstract variable
 * 
 * 		subclass examples:
 * 			- club
 * 			- dagwood
 * 			- cuban
 */
public abstract class Sandwich {
	
	// State aka variables
	private int slicesOfBread; // not going to make protected because I can handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; // protected variable available to: the class, the package, the subclass
//	private boolean isToasted;
	
	// NO-ARGS Constructor by convention: future frameworks will require 
	// All POJO's and abstract classes will require NO-ARGS Constructor
	
	public Sandwich() {	}
	
	// overloading must be in the same class
	
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
	super();
	this.slicesOfBread = slicesOfBread;
	this.meats = meats;
	this.toppings = toppings;
	this.name = name;
	this.size = size;
}




	// Behavior

	public abstract void prepping();
	
	/**
	 * takeBite() decrements sandwich size by 1
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		// this. is not required because there is no other size variable in the parameter or the method
		this.size--; 
		return this.size;
	}
	
	public int takeBite(int biteSize) {
		this.size -= biteSize; 
		return this.size;
	}
	
	/*
	 *  creating a getter and setter for the private variable slicesOfBread
	 */
	public int getSlicesOfBread() {
		return this.slicesOfBread;
	}
	
	
	/**
	 * 
	 *  setting the property int slicesOfBread
	 *  	do not pass a negative number as an argument if you do I will set it to 0
	 * 
	 */
	
	public void setSlicesOfBread(int slicesOfBread) {
		if (slicesOfBread < 0) {
			this.slicesOfBread = 0;
			throw new NoNegativeArgumentException();
		} else {			
			this.slicesOfBread = slicesOfBread;
		}
	}
	
}
