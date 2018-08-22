package com.ex.classes;

public class Bird extends Pet{
	private String breed;
	private boolean canFly;
	
	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(String name, int age, boolean isAlive, String breed, boolean canFly) {
		super(name, age, isAlive);
		this.breed=breed;
		// TODO Auto-generated constructor stub
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " chirps");
	}
	

}