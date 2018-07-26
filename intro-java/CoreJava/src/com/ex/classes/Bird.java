package com.ex.classes;

public class Bird extends Pet {
	private String breed;

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(String name, int age, boolean isAlive, String breed) {
		super(name, age, isAlive);
		// TODO Auto-generated constructor stub
	}

	public String getBreed() {
		return breed;
	}

	public void setNumberWIngs(String breed) {
		this.breed = breed;
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " chirps");
		
	}
	

}
