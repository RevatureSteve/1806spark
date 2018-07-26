package com.ex.classes;

public abstract class Pet {
	private String name;
	private int age;
	private boolean isAlive;
<<<<<<< HEAD
	
=======

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	
=======

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Pet(String name, int age, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.isAlive = isAlive;
	}
<<<<<<< HEAD
	
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
	
	public abstract void speak();
=======

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

	/**
	 * Lets the pet speak in its own way
	 */
	public abstract void speak();
	
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
