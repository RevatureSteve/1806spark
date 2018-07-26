package com.revature.pojo;

import com.revature.abstracts.Sandwich;

public class Club extends Sandwich {

	private boolean isToasted;
	private int numberOfToothpicks;

	/**
	 * 
	 */
	public Club() {
		super();
	}

	/**
	 * @param slicesOfBread
	 * @param meats
	 * @param toppings
	 * @param name
	 * @param size
	 */
	public Club(int slicesOfBread, String[] meats, String[] toppings, String name, int size) {
		super(slicesOfBread, meats, toppings, name, size);
		// TODO Auto-generated constructor stub
	}

	// behavior
	@Override
	public void startPrep() {
		System.out.println("Prep started on the club");

	}

	// getters and setters
	public boolean isToasted() {
		return isToasted;
	}

	public void setToasted(boolean isToasted) {
		this.isToasted = isToasted;
	}

	public int getNumberOfToothpicks() {
		return numberOfToothpicks;
	}

	public void setNumberOfToothpicks(int numberOfToothpicks) {
		this.numberOfToothpicks = numberOfToothpicks;
	}

	@Override
	public int takeBite() {
		System.out.println("Taking a bite of a club");
		return super.size; //fix by changing to protected so subclasses can see it
	}

}
