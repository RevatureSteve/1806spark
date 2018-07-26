package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich {
	
	// state
	private boolean isToasted;
	private int numberOfToothpicks;
	
	
	// NO-ARG
	public Club() {
		super();
	}

	public Club(String name, int slicesOfBread, String[] meats, String[] toppings, int size) {
		super(name, slicesOfBread, meats, toppings, size);
	}
	
	@Override
	public int takeBit() {
		System.out.println("Taking a bite of a Club");
		return super.takeBit();
	}
	
	
	
	@Override
	public void prepTime() {
		System.out.println("Club being made, will toast");
	}
	
	
}
