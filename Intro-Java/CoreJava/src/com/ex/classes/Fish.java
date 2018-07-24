package com.ex.classes;

public class Fish extends Pet{
	
	private String name;
	private int age;
	private boolean isAlive;
	private int numFin;
	
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Fish(String name, int age, boolean isAlive, int numFin) {
		super();
		this.name = name;
		this.age = age;
		this.isAlive = isAlive;
		this.numFin = numFin;
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

	public int getNumFin() {
		return numFin;
	}

	public void setNumFin(int numFin) {
		this.numFin = numFin;
	}	
}