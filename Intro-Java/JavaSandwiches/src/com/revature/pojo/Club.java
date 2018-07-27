package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich{

	// state
	private boolean isToasted;
	private int numberOfToothpicks;
	// protected int size; we inherited this property as size is protected in the parent
	
	//NO-ARG
	public Club() {}
	
	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
	}



	@Override
	public int takeBite() {
	System.out.println("Taking a bit of a club");
		return this.size;
	}
	
	
	@Override
	public void prepping() {
		System.out.println("Club being made, will toast");
	}

}
