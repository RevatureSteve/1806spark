package com.revature.pojo;

import com.revature.abstracts.Sandwich;

/*THIS HAS A NO ARGS CONSTRUCTOR!
 * public class Club extends Sandwich {

	@Override
	public void prepping() {
		// TODO Auto-generated method stub
		System.out.println("Club being made, will toast!");
	}*/
	
public class Club extends Sandwich {

	
	
	
	// protected int size; we inherited this property as size is protected in the parent.
	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
	}

	// state
	private boolean isToasted;
	private int numberOfToothpicks;
	
	// no-args constructor
	public Club() {};
	
	/* A CHILD CANNOT SEE ITS PARENT'S PRIVATE CONTENT. 
	@Override
	public int takeBite() {
		System.out.println("Taking a bite of a Club");
		return this.size;
	}
	*/
	// this is pulling from a protected file, children can see parents protected vars.
	
	
	
	@Override //the size is a protected var, not private.
	public int takeBite() {
		System.out.println("Taking a bite of a Club");
		return this.size;
	}
	
	@Override
	public void prepping() {
		// TODO Auto-generated method stub
		System.out.println("Club being made, will toast!");
	}

	
}
