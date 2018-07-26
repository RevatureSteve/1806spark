package com.ex.classes;

public class Bird extends Pet{
	
	private int wings;

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(String name, int age, boolean isAlive, int wings) {
		super(name, age, isAlive);
		this.wings = wings;

	}

	@Override
	public void speak() {
			System.out.println(this.getName() + " chirp");
		
	}

	

	
	
	

}

	