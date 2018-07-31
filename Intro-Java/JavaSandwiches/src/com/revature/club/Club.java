package com.revature.club;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich{
	
	
	private boolean isToasted;
	private int numberOfToothpicks;
	//protected int size; (implicitly here) we inherited this state from parent class
	
	
	
	
	
	public Club() {
		super();
	}



	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
		
	}






	@Override
	public void prepping() {
		System.out.println("Club being made, will toast");	
	}



	@Override
	public int takeBite() {
		System.out.println("Taking a bite of club");
		return this.size;
	}
	
	

}
