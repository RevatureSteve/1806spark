package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich {
	
	//POJO must have state, no arg, and override 
	
	// state
	
	private boolean isToasted;
	private int numberOfToothpicks; 
	
	// NO_ARG (NEEDED!)
	public Club() {}
	
	

	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
	}



	@Override
	public int takeBite() {
		System.out.println("Taking a bite of a club");
		return this.size;
	}
	
	
	@Override
	public void prepping() {
		System.out.println("Club being made, will toast");
		
	}

}
