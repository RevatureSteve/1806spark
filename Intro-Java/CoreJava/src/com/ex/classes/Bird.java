package com.ex.classes;


public class Bird extends Pet{
	
	private String color;

	public Bird() {
		super();
	}

	public Bird(String name, int age, boolean isAlive, String color) {
		super(name, age, isAlive);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void speak() {
		System.out.println(this.getName() + " hi");
	}
	
	

}
