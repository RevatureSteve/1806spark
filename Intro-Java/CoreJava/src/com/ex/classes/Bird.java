package com.ex.classes;

public class Bird extends Pet {
	
	private String beak;

	public Bird() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bird(String name, int age, boolean isAlive, String beak) {
		super(name, age, isAlive);
		this.beak = beak;
		// TODO Auto-generated constructor stub
	}

	public String getBeak() {
		return beak;
	}

	public void setBeak(String beak) {
		this.beak = beak;
	}
	
	@Override
	public void speak() {
		System.out.println(this.getName() + " tweets");
	}

}
