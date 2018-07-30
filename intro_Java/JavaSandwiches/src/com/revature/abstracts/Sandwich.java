package com.revature.abstracts;

import com.revature.exceptions.NoNegativeArgumentException;

/**
 * Sandwich class is going to be a template for creating
 * 	subclasses for specific sandwiches
 * THis will be an abstract class
 * 	subclass examples:
 * 	-club
 * 	-dagwood
 * 	-cuban
 * @author tyler
 *
 */
/*
 *  abstract keyword can be used in two locations:
 *  Classes-
 *  Methods-
 */
public abstract class Sandwich {
//always create a state, behavior, and no-args constructor
	//state aka variables
	private int slicesOfBread;  //not going to make protected because I can handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size;  //protected variable available to the class, the package, the subclass most commonly used inside abstract classes
//	private boolean isToasted;
	
// NO_ARGS constructor by convention: future frameworks will require
	// constructors with same name and different parameters = OVERLOADING- must be done in the same class
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



//Behavior
public abstract void prepping();    

/**
 * takeBite() decrements the sandwich size by 1
 * @return remaining size
 */

public int takeBite() {
	
	this.size --; // this. is not required but there is no other size variable in the parameter or the method
	return this.size;
	
}
public int takeBite(int biteSize) { //method overloading, same name different parameter
	
	this.size -= biteSize; // same as this.size = this.size - biteSize;
	return this.size;
	
}

// creating a getter/setter for the private variable slicesOfBread

public int getSlicesOfBread() {
	return slicesOfBread;
	
}
/**
 * Setting the property int slicesOfBread, do not pass a negative number as an argument if you do I will set it to 0
 * @param slicesOfBread
 */
public void setSlicesOfBread(int slicesOfBread) {
	if(slicesOfBread < 0) {
				this.slicesOfBread = 0;
				throw new NoNegativeArgumentException();
	} else {
		this.slicesOfBread = slicesOfBread;
	}
}

}

