package com.revature.pojo;

import com.revature.abstracts.Sandwhich;

public class Club extends Sandwhich{

	private boolean isToasted;
	private int numberOfToothpicks;
	
	public Club() {}
	
	
	
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
		System.out.println("Taking a bite of a club");
		return this.size;
	}
	
	

}
