package com.ex.classes;

public class Dog extends Pet{
	
	private String breed;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, boolean isAlive, String breed) {
		super(name, age, isAlive);  // functionality that's being received
		this.breed = breed;
		// TODO Auto-generated constructor stub
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	@Override
	public void speak() {
		System.out.println(this.getName() + " barks");
	}
	
}
