package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich {

	// State
	private boolean isToasted;
	private int numberOfToothpicks;
	// protected int size; we inherited this property as size is protected in the
	// parent

	// NO-ARGS
	public Club() {
		super();
	}

	public Club(boolean isToasted, int numberOfToothpicks, int size) {
		super();
		this.isToasted = isToasted;
		this.numberOfToothpicks = numberOfToothpicks;
		this.size = size;
	}

	// Behavior

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
