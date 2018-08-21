
package com.ex.classes;

public class Fish extends Pet {
	private int numFins;

	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param age
	 * @param isAlive
	 */
	public Fish(String name, int age, boolean isAlive, int numFins) {
		super(name, age, isAlive);
		this.numFins = numFins;
		// TODO Auto-generated constructor stub
	}

	public int getNumFins() {
		return numFins;
	}

	public void setNumFins(int numFins) {
		this.numFins = numFins;
	
	}

	@Override
	public void speak() {
		System.out.println("Blub Blub");
	}

}
