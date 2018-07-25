package com.revature.abstracts;

/**
*sandwich class is going to a template for creating subclasses for specific sandwiches
*we are going to make this class abstract
*
*	subclass:
*		-club
*		-dagwood
*		-cuban
*/
public abstract class Sandwich {
	/*
	 * abstract keywords can be used in 2 locations:
	 * 	-classes
	 * 	-methods
	 * no such thing as an abstract variable
	 */
	
	//state aka variables
	private int slicesOFBread; //not going to make protected b/c I handle the validation here for all of them 
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; //proctected available to: the class, the package, the subclass
	/*private boolean isToasted;*/
	
	//NO-ARGs constructor by convention: future frameworks will require
	public Sandwich( ) {}
	
	public Sandwich(int slicesOFBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOFBread = slicesOFBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}


	//behavior
	
	public abstract void prepping();
	/**
	 * takeBite() decrements the sandwich size by 1
	 * @return current remaining size
	 */
	public int takeBite( ) {
		this.size--;	//this. is not required b/c there is no other size var in the parameter or in the method
		return this.size;
	}
	
	public int takeBite(int biteSize) {
		this.size -= biteSize;	//-= is the same as: this.size = this.size - biteSize
		return this.size;
	}
	
	/*
	 *creating a getter and setter for the private variable slicesOfBread 
	 */
	public int getSlicesOfBread( ) {
		return this.slicesOFBread;
	} 
	
	/**
	 *	getting the property in slicesOfBread 
	 *		do not pass a negative number as an arg, if you do I will set it to 0 
	 * @param slicesOfBread
	 */
	public void setSlicesOfBread(int slicesOfBread) {
		if(slicesOfBread < 0) {
			System.out.println("not enough bread, setting it to 0");
			this.slicesOFBread = 0;
		} else {			
			this.slicesOFBread = slicesOfBread; 
		}
	}
		
	
	
	
	
}
