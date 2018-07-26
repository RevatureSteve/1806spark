package com.ex.classes;

public class Bird extends Pet {
	private String color;
	
	public Bird() {
		// TODO Auto-generated constructor stub
	}

	public Bird(String name, int age, boolean isAlive, String color) {
		super(name, age, isAlive);
		this.color = color;
		// TODO Auto-generated constructor stub
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void speak() {
		System.out.println("Tweep Tweep");
		
	}
}
