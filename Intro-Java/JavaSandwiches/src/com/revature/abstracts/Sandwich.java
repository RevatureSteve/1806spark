package com.revature.abstracts;

<<<<<<< HEAD
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
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146

	// NO-ARGS Constructor by convention: future frameworks will require
	public Sandwich() {
	}
<<<<<<< HEAD

	/**
	 * @param slicesOfBread
	 * @param meats
	 * @param toppings
	 * @param name
	 * @param size
	 */
=======
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Sandwich(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super();
		this.slicesOfBread = slicesOfBread;
		this.meats = meats;
		this.toppings = toppings;
		this.name = name;
		this.size = size;
	}

<<<<<<< HEAD
	// behavior
	/**
	 * takeBite() decrements the size of the sandwich size by one
	 * 
	 * @return current remaining size
	 */
	public int takeBite() {
=======
	// Behavior
	
	public abstract void prepping();
	

	/**
	 * takeBite() decrements the sandwich by 1
	 * 
	 * @return remaining size of sandwich
	 */
	public int takeBite() {
		// this. is not required because there is no other size variable in the
		// parameter or in the method
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		this.size--;
		return this.size;
	}

<<<<<<< HEAD
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
=======
	public int takeBite(int biteSize) {
		this.size -= biteSize; // same as: this.size = this.size - biteSize;
		return this.size;
	}

	
	/*
	 * 	creating a getter and setter for the private variable slicesOfBread
	 */
	public int getSlicesOfBread() {
		return slicesOfBread;
	}
	
	/**
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
	
	
	
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146

}
