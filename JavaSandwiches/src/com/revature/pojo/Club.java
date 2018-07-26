package com.revature.pojo;

import com.revature.abstracts.Sandwiches;

public class Club extends Sandwiches {
	
	// state
	private boolean isToasted;
	private int numberOfToothpicks;
	// protected int size; we inherited this property as size is protected in the parent
	
	//NO-ARGS
	public Club() {
	}
	
	

	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
	}



	@Override
	public int takeBite() {
		System.out.println("Taking a bit of a club");
		return super.size;
	}
	@Override
	public void prepping() {
		// TODO Auto-generated method stub
		System.out.println("Club being made, will toast");
	}

}
