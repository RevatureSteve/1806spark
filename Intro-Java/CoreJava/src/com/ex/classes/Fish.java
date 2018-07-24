package com.ex.classes;

public class Fish extends Pet {
	private int numberFins;

	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super(name, age, isAlive);
		this.numberFins = numberFins;
	}

	public int getNumberFins() {
		return numberFins;
	}

	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " bubbles");
	}

}
