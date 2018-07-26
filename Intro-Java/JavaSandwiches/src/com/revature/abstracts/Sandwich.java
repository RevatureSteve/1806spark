package com.revature.abstracts;

/*
 * 	abstract keyword can be used in 2 locations:
 * 			-classes
 * 			-methods
 * 	no such thing as an abstract variable
 */
/**
 * Sandwich class is going to be a template for creating
 * 		subclasses for specific sandwiches
 * We are going to make this class abstract
 * 
 * 		subclass examples:
 * 			-club
 * 			-dagwood
 * 			-cuban
 *
 */
public abstract class Sandwich {
	
	private int slicesOfBread;
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; //protected variable available to: the class, the package, subclasses
//	private boolean isToasted;
	
//	no-args constructor by convention: future frameworks will require
	
	// for this class, need subclasses to instantiate it as opposed to System class
	// so can't be a private constructor
	// look into what using super() means
	// cf. making a Pet array, abstract Pet class but making room for Pet datatype placeholders
	// also, I thought that subclasses don't inherit their parent's contructors
	public Sandwich() {}
	
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}
	
	public abstract void prepping();

	/**
	 * takeBite() decrements the sandwich by 1
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

	public int getSlicesOfBread() {
		return slicesOfBread;
	}

	/**
	 * 	Setting the property of slicesOfBread
	 * 		do not pass a negative number as an argument if you do I will set it to 0
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) {
		if (slicesOfBread < 0) {
			System.out.println("cannot have a negative value for sliceOfBread, setting it to 0");
			this.slicesOfBread = 0;
		} else this.slicesOfBread = slicesOfBread;
	}
	
}