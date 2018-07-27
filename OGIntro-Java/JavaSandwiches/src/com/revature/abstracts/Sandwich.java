package com.revature.abstracts;

<<<<<<< HEAD
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
=======
import com.revature.exceptions.NoNegativeArgumentException;

/*
 * 	abstract keyword can be used in 2 locations:
 * 			-classes
 * 			-methods
 * 	no such thing as an abstract variable
 */
/**
 * Sandwich class is going to be a template for creating subclasses for specific
 * sandwiches We are going to make this class abstract
 * 
 * subclass examples: -club -dagwood -cuban
 */
public abstract class Sandwich {

	// State aka variables
	private int slicesOfBread; // not going to make protected because I handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size; // protected variable available to: the class, the package, the subclass

//		private boolean isToasted;
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwich() {
	}
<<<<<<< HEAD
	public Sandwich(int sliceOfBread, String[] meats, String[] toppings, String[] name, int size) {
	super();
	this.slicesOfBread = sliceOfBread;
	this.meats = meats;
	this.toppings = toppings;
	this.name = name;
	this.size = size;
}


=======
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e

	// Behavior
	
	public abstract void prepping();
	
<<<<<<< HEAD
	
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
=======

	/**
	 * takeBite() decrements the sandwich by 1
	 * 
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		// this. is not required because there is no other size variable in the
		// parameter or in the method
		this.size--;
		return this.size;
	}

	public int takeBite(int biteSize) {
		this.size -= biteSize; // same as: this.size = this.size - biteSize;
		return this.size;
	}

	
	/*
	 * 	creating a getter and setter for the private variable slicesOfBread
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	 */
	public int getSlicesOfBread() {
		return slicesOfBread;
	}
	
	/**
<<<<<<< HEAD
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

	
	
=======
	 *  Setting the property int slicesOfBread
	 *  	do not pass a negative number as an agrument if you do I will set it to 0
	 * @param slicesOfBread
	 * @throws NoNegativeArgumentException 
	 */
	public void setSlicesOfBread(int slicesOfBread) throws NoNegativeArgumentException {
		if(slicesOfBread < 0) {
			this.slicesOfBread = 0;
			throw new NoNegativeArgumentException();
			
		}else {
			this.slicesOfBread = slicesOfBread;
		}
	}
	
	
	

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
