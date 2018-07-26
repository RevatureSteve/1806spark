package com.ex.classes;

public class Bird extends Pet {

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(String name, int age, boolean isAlive) {
		super(name, age, isAlive);
		// TODO Auto-generated constructor stub
	}
	
	public void speak() {
		System.out.println(this.getName() + " cheep");
	}
}
