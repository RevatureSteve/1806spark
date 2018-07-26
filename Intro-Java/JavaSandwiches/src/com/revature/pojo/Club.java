package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich {
	
	private boolean isToasted;
	private int numberOfToothpicks;
	
	public Club() {}
	
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