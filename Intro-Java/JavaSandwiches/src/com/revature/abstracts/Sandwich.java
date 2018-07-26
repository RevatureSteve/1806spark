package com.revature.abstracts;

/**
 * Sandwich class is going to be a template for creating subclasses for specific
 * sandwiches
 * 
 * We are going to make this class abstract
 * 
 * subclass examples: -club -dagwood -cuban
 * 
 * @author chin2
 *
 */
public abstract class Sandwich {
	/*
	 * abstract keyword can be used in 2 locations: -classes -methods no such thing
	 * as an abstract variable
	 */
	private String name;
	private int slicesOfBread; // Not going to make protected because I handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	protected int size; //protected - package and sub-classes can access it
//	private boolean isToasted;

	// No-Args constructor
	public Sandwich() {
		super();
	}

	public Sandwich(String name, int slicesOfBread, String[] meats, String[] toppings, int size) {
		super();
		this.name = name;
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.size = size;
	}
	
	
	// Behavior
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSlicesOfBread() {
		return slicesOfBread;
	}

	/**
	 * Setting the property int slicesOfBread
	 * 		do not pass a negative number as an argument (will be set to 0)
	 * @param slicesOfBread number of bread slices
	 */
	public void setSlicesOfBread(int slicesOfBread) {
		if(slicesOfBread < 0) {
			System.out.println("cannot have a negative value for slicesOfBread, setting it to 0");
			this.slicesOfBread = 0;
		}
		else {
			this.slicesOfBread = slicesOfBread;
		}
	}

	public String[] getMeats() {
		return meats;
	}

	public void setMeats(String[] meats) {
		this.meats = meats;
	}

	public String[] getToppings() {
		return toppings;
	}

	public void setToppings(String[] toppings) {
		this.toppings = toppings;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public abstract void prepTime();
	
	/**
	 * takeBit() decrements the sandwich size by 1
	 * 
	 * @return remaining size of sandwich
	 */
	public int takeBit() {
		this.size--;
		return size < 0 ? 0: this.size;
	}
	
	/**
	 * decrements the sandwich by biteSize
	 * @param biteSize size of bite
	 * @return remaining size of sandwich
	 */
	public int takeBit(int biteSize) {
		this.size -= biteSize;
		return size < 0 ? 0: this.size;
	}

}
