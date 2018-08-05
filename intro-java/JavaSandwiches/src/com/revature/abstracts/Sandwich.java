package com.revature.abstracts;


import com.revature.NoNegativeArgumentException;
/**
 * Sandwich class is going to be a template for creating subclasses for specific
 * sandwiches
 * 
 * subclass examples: club dagwood cuban
 */
public abstract class Sandwich {

	// state aka variables
	private int slicesOfBread; // not going to make protected because i handle validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size;
	// private boolean isToasted;

	// No-Args Constructor required
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
	 * takeBike() decrements the sandwich size by 1
	 * 
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		this.size--;
		return this.size;
	}

	public int takeBite(int biteSize) {
		this.size -= biteSize;
		return this.size;
	}

	/*
	 * getter/setter for slicesOfBread
	 */

	public int getSlicesOfBread() {
		return slicesOfBread;
	}

	/**
	 * Setting the property int slicesOfBread.
	 * do not pass a negative number as an argument
	 * else it will return 0
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) throws NoNegativeArgumentException{
		if (slicesOfBread < 0) {
			System.out.println("cannot have a negative value for slicesOfBread, setting it to 0");
			this.slicesOfBread = 0;
			throw new NoNegativeArgumentException();
		} else {
			this.slicesOfBread = slicesOfBread;
		}
	}

}
/**
 * abstract keyword can be used in 2 locations: classes and methods
 * 
 * 
 */