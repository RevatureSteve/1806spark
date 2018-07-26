package com.revature.abstracts;

import com.reavature.exceptions.NoNegativeArgumentException;

/**
 * Sandwich class is going to be a template for creating a subclass for specific
 * sandwiches we are going to make this class abstract
 * 
 * @author becklarson-Work
 *
 */

/*
 * abstract keyword can be used in two locations: -classes -methods no such
 * thing as an abstract variable
 * 
 * 
 * 
 * subclass examples: -club -dagwood -cuban
 */

public abstract class Sandwich {

	// State aka variables
	private int slicesOfBread; //not going to make protected because I can handle the calidation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; //protected variable: class, package, and subclasses
	
	// private boolean isToasted;

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwich() {
		
	}

	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}
	
	// Behavior
	
	public abstract void Prepping(); //Abstract class has no body {}
	/**
	 * takeBite() decrements the sandwich size by one
	 * 
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		size--;
		return size;
	}
	
	public int takeBite(int biteSize) {
		size -= biteSize;
		return size;
	}
	// creating a getter and a setter for the private variable slicesOfBread

	public int getSlicesOfBread() {
		return slicesOfBread;
	}

	/**
	 * Setting the property int slicesOfBread
	 * 	do not pass a negative number as an arg 
	 * 	or the bread with be set to 0
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) {
		if(slicesOfBread < 0) {
			throw new NoNegativeArgumentException("Stop it! You must have a number above 0 for the slices of bread");
		}else {
			this.slicesOfBread = slicesOfBread;
		}

	}
	
	
	
}
