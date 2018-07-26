package com.revature.abstracts;

/**
 * 
 * @author marci
 *
 *         Sandwich class is going to be a template for creating subclasses for
 *         specific sandwiches We are going to make it abstract subclass
 *         examples -club -bagwood -cuban
 */
public abstract class Sandwich {
	private int slicesOfBread;
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size;
	// private boolean isToasted; --because cuban is not toasted, one of subclasses
	// will not use it

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwich() {
	}

	/**
	 * @param slicesOfBread
	 * @param meats
	 * @param toppings
	 * @param name
	 * @param size
	 */
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}

	// behavior
	/**
	 * takeBite() decrements the size of the sandwich size by one
	 * 
	 * @return current remaining size
	 */
	public int takeBite() {
		this.size--;
		return this.size;
	}

	/**
	 * takeBite(int biteSize) decrements the size of the sandwich size by biteSize
	 * 
	 * @param biteSize size of a bite
	 * @return current remaining size
	 */
	public int takeBite(int biteSize) {
		this.size -= biteSize;
		return this.size;
	}

	/**
	 * abstract method for starting preparation
	 */
	public abstract void startPrep();

	// getters and setters
	public int getSlicesOfBread() {
		return slicesOfBread;
	}

	/**
	 * Setting the propery int slicesOfBread do not pass a negative number as an argument, if you try I will set it to 0
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) {
		if (slicesOfBread < 0) {
			System.out.println("cannot have a negative value for slicesOfBread, setting it to 0");
			this.slicesOfBread = 0;
		} else {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
