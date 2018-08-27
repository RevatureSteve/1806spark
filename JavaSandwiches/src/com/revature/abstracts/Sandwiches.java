package com.revature.abstracts;

/**
 * Java Docs comment are in blue, regular comment are in green
 * 
 * @author Alex Moraga
 *
 *         Sandwich class is going to be a template for creating subclasses for
 *         specific sandwiches. We are goint to make thie classs abstract.
 * 
 *         subclass examples: -club -dagwood -cuban
 *
 */

public abstract class Sandwiches {

	/*
	 * abstract keyword can be used in 2 locations: -classes -methods no such thing
	 * as an abstract variable
	 * 
	 */
	// State aka variables
	private int slicseOfBread; // not going to make it protected because I can handle the validation here for
								// all of them
	private String[] meats;
	private String[] toppings;
	private String[] name;
	protected int size; // protected variable avaliable to: the class, the package, the subclass
//		private boolean isToasted;
	private int slicesOfBread;

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwiches() {
	}

	public Sandwiches(int slicseOfBread, String[] meats, String[] toppings, String[] name, int size) {
		super();
		this.slicseOfBread = slicseOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}

	// Behavior

	public abstract void prepping();

	/**
	 * takeBite() decrements the sandwich by 1
	 * 
	 * @return remaining size of the sandwich
	 */
	public int takeBite() {
		// this. is not required but there is not other size variable in the parameter
		// or the method
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
		return this.slicseOfBread; // this. can be removed
	}

	/**
	 * Setting the property int slicesOfBread
	 * 		do not pass a negative number as an argument, if you do I will set it to 0
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) {
		if (slicesOfBread < 0) {
			System.out.println("Cannot have a negative value for sliceOfBread, setting it to 0");
			this.slicesOfBread = 0;
		} else {
			this.slicesOfBread = slicesOfBread;
		}
	}

}