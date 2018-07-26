package com.revature.abstracts;
// each period is representing a break

/*
 *   Sandwish Class is going to be a template for creating subclasses for specific sandwishes
 * 
 * */

/**
 * abstract keyword can be used in 2 location:
 * 
 * -classes -method no such thing as abstract variable
 * 
 * 
 * subclasss eample: -clud -dagwood -cuban
 */
//public class Sandwish // if remove abstract keyword it would be a concrete method

public abstract class Sandwish{
// add the abstract keyword

	// Stake aka variables
	private int sliceOfBread; // not going to make protected becasue i handle the validation here for all of them
	private String[] meats;
	private String[] toppings;
	private String name;
	protected int size;  // protected variable available to: class, the package, the subclass.
//	private boolean istoasted;

	// NO-ARGS constructor by convention: future frame work will required

	public Sandwish() {
		// no-args	
	}

	// these are field generate by clicking source and generate constructor using field
	public Sandwish(int sliceOfBread, String[] meats, String[] toppings, String name, int size) {
	super();
	this.sliceOfBread = sliceOfBread;
	this.meats = meats;
	this.toppings = toppings;
	this.name = name;
	this.size = size;
}



	// Behavior
	  public abstract void prepping(); //you need the abstract keyword ..//for abstract method
	
	
	/*
	 *  takeBite () decrements the sandwish by 1
	 *  @return remaining size of sandwish
	 *  
	 */
	 

	public int TakeBite() {
		 //this.size is not required but there is no other size variable  in the parameter or in the method
		this.size --; //same as: this.size = this.size - biteSize;
		return this.size;
	}
	

	public int TakeBite(int biteSize) {
		 //this.size is not required but there is no other size variable  in the parameter or in the method
		this.size -= biteSize; //same as: this.size = this.size - biteSize;
		return this.size;
	}
	
	/*creating a getter and setter for the private variable sliceOfBread
	 * 
	 */
		public int getSliceOfBread() {
			return sliceOfBread;
			// this allow who ever call it to get what ever the bread is
		}
		
		
		/*
		*
		* setting the property in sliceOfBread
		*  do not pass a negative number as an argument
		*  @param sliceOfBread
		*
		*/
		
		public void setSliceOfBread(int sliceofBread) {
			// this is returning nothing
			if(sliceOfBread < 0) {
				System.out.println("cannot have a negative slice of bread, setting it to 0");
				this.sliceOfBread= 0;
			} else {
			this.sliceOfBread = sliceOfBread;
			}
			
			
		}
}
