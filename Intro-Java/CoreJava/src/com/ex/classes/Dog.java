package com.ex.classes;

public class Dog {
	
	private String name;
	private int age;
	private boolean isAlive;
	private String breed;
	
	
	public Dog() {
		super();
	}

	
	public Dog(String name, int age, boolean isAlive, String breed) {
		super();
		this.name = name;
		this.age = age;
		this.isAlive = isAlive;
		this.breed = breed;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	
}
