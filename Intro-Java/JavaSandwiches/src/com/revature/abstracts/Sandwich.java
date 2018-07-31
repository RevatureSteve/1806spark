package com.revature.abstracts;

/*
 * 
 *  Sandwich class is going to be a template for creating 
 *  subclasses for specific sandwiches
 *  we are going to make this class abstract
 *  Below is Java docs comment with 2 asterisks
 */
/** Abstract keyword can be used in 2 location:
 *  -classes
 *  -methods
 * no such thing as an abstract variable
 * 
 * 		subclasses examples:
 * 			-club
 * 			-dagwood
 * 			-cuban
 * 
 **/

public abstract class Sandwich {
	
// State/Fields aka variables
	private int slicesOfBread; //not going to make protected because I can handle validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; //Protected variable availble to the class, the package, the subclass
//	private boolean isToasted;
	
	
	//NO-ARGS constructor by convention: future frameworks will require. 
	public Sandwich() {
		super();
	}
	
	
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}



		//Behavior
	
	
	public abstract void prepping();
	
	

/**
 * takeBite() decrements the sandwich size by 1
 * @return current remaining size of sandwich
 */
	public int takeBite() {
		this.size--; //this. is not required because there is no other size variable in the parameter or in the method
		return this.size;
	}
	
	public int takeBite(int biteSize) {
		this.size-= biteSize; //this. is not required because there is no other size variable in the parameter or in the method
		// same as writing this.size = this.size - biteSize;
		return this.size;
	}
/*
 * Creating a getter and setter for the private variable for the slicesOfBread	
 */
	
public int getSlicesOfBread() {
	
	return this.slicesOfBread;
}


/**
 * 
 *  Setting the propert int slicesOfBread, do not pass a negative number as an argument
 * 			 or if you do, I will set it to 0;
 * @param slicesOfBread
 */
public void setSlicesOfBread(int slicesOfBread) {
	if(slicesOfBread < 0) {
		System.out.println("Cannot have a negative value for sliceOfValue, setting it to 0");
		this.slicesOfBread = 0;
	}
	else {
		this.slicesOfBread = slicesOfBread;
	}
}

}
