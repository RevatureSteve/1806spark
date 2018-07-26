package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich {

	// state
	private boolean isToasted;
	private int numToothpicks;

	// no-arg
	public Club() {
	}

	public Club(boolean isToasted, int numToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numToothpicks = numToothpicks;
		this.size = size;
	}

	public int takeBite() {
		System.out.println("Taking a bite of a club");
		return this.size;
	}

	@Override
	public void prepping() {
		System.out.println("Club being made, will toast");
	}

}
