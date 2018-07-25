package com.revature.pojo;

import com.revature.abstracts.Sandwich;

<<<<<<< HEAD
public class Club extends Sandwich {
	
	//POJO must have state, no arg, and override 
	
	// state
	
	private boolean isToasted;
	private int numberOfToothpicks; 
	
	// NO_ARG (NEEDED!)
	public Club() {}
	
	

=======
public class Club extends Sandwich{

	// state
	private boolean isToasted;
	private int numberOfToothpicks;
	// protected int size; we inherited this property as size is protected in the parent
	
	//NO-ARG
	public Club() {}
	
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
	}



	@Override
	public int takeBite() {
<<<<<<< HEAD
		System.out.println("Taking a bite of a club");
=======
	System.out.println("Taking a bit of a club");
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		return this.size;
	}
	
	
	@Override
	public void prepping() {
		System.out.println("Club being made, will toast");
<<<<<<< HEAD
		
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	}

}
