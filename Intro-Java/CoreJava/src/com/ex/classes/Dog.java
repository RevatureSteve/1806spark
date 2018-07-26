package com.ex.classes;

public class Dog extends Pet {
<<<<<<< HEAD
	
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
	
	
=======
	private String breed;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age, boolean isAlive, String breed) {
		super(name, age, isAlive);
		this.breed = breed;
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

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
