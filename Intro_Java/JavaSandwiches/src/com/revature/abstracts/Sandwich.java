package com.revature.abstracts;

/**
 * Java Docs comment are in blue, regular comment are in green
 * 
 * @author Eddie Grays
 * 
 *         Sandwich class is going to be a template for creating subclasses for
 *         specific sandwiches. We are going to make this class abstract.
 * 
 *         subclass examples: -club -dagwood -cuban
 *
 */

public abstract class Sandwich {

	/*
	 * abstract keyword can be used in 2 locations: -classes -methods no such thing
	 * as an abstract variable
	 */

	// State aka variables
	private int slicesOfBread; // not going to make protected because I handle the validation here for all of
								// them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; // protected variable available to: the class, the package, the subclass

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

	public abstract void prepping();

	/**
	 * takeBite() decrement the sandwich size by 1 return the current remaining size
	 * of sandwich
	 * 
	 * @return
	 */
	public int takeBite() {
		this.size--; // this. is not required because there is no other size variable in the
						// parameter or in the method
		return this.size;
	}

	public int takeBite(int biteSize) {
		this.size -= biteSize; // -= same as: this.size = this.size - biteSize;
		return this.size;
	}

	/*
	 * creating a getter and setter for the private variable slicesOfBread
	 */

	public int getSlicesOfBread() {
		return this.slicesOfBread;
	}
	
	/**
	 * Setting the property int slicesOfBread
	 * 		do not pass a negative number as an argument if you do I will set it to 0
	 * @param slicesOfBread
	 */

	public void setSlicesOfBread(int slicesOfBread) {
		if (slicesOfBread <= 0) {
			System.out.println("Cannot have a negative value for sliceOfBread, setting it to 0");
			this.slicesOfBread = 0;
		} else {
			this.slicesOfBread = slicesOfBread;
		}
	}

}
