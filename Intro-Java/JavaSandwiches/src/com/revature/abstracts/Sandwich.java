package com.revature.abstracts;

/*
 * abstract keyword can be used in 2 locations:
 * 			- classes
 * 			- methods
 * no such thing as an abstract variable 
 * 
 */

/**
 * Sandwich class is going to be a template for creating subclasses for
 * specific sandwiches
 * 
 * @author christopherholmes
 *
 *         We are going to make this class abstract subclass examples: - club -
 *         dagwood - cuban
 */

public abstract class Sandwich {

	// State aka variables
	private int slicesOfBread; // not going to make protected because I can handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String[] name;
	protected int size; // protected means the package and subclasses can access this
	//only used in abstract classes
//	private String[] isToasted;

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwich() {
	}
	public Sandwich(int sliceOfBread, String[] meats, String[] toppings, String[] name, int size) {
	super();
	this.slicesOfBread = sliceOfBread;
	this.meats = meats;
	this.toppings = toppings;
	this.name = name;
	this.size = size;
}



	// Behavior
	
	public abstract void prepping();
	
	
	/**
	 * takeBite() decrements the sandwich size by 1
	 * @return remaining size
	 */
	public int takeBite() {
		// this. is not required because there is no other size variable in the parameter or the method
		this.size--;
		return this.size;
	}
	
	public int takeBite(int biteSize) {
		// this. is not required because there is no other size variable in the parameter or the method 
		this.size -= biteSize; // same as: this.size - biteSize
		return this.size;
	}
	
	/*
	 * creating a getter and setter for the private variable slicesofBread
	 */
	public int getSlicesOfBread() {
		return slicesOfBread;
	}
	
	/**
	 * Setting the property int slicesOfBread
	 * 	do not pass a negative number as an argument if you do I will set it to 0
	 * @param slicesOfBread
	 */
	
	public void setSlicesOfBread(int slicesOfBread) {
		if(slicesOfBread < 0) {
			System.out.println("cannot have a negative value for sliceOfBread, setting it to 0");
			this.slicesOfBread = 0;
		}else {
		this.slicesOfBread = slicesOfBread;

		}
	}

	
	
}
