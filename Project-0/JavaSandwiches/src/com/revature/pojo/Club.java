package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich{

	//state
	private boolean isToasted;
	private int numOfToothpicks;
	
	//NO-ARG, every POJO must have this
	public Club() {
		
	}
	
	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numOfToothpicks = numberOfToothpicks;
		this.size = size;
		
	}

	@Override
	public int takeBite() {
		System.out.println("Taking a bite of a club!");
		return size;
	}
	
	@Override
	public void Prepping() {
		System.out.println("Club is being made, will toast");
		
	}

}
