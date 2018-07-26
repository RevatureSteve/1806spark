package com.ex.classes;

<<<<<<< HEAD
public class Fish extends Pet{
	
	private String name;
	private int age;
	private boolean isAlive;
	private int numFin;
	
=======
public class Fish extends Pet {
	private int numberFins;

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	
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
=======

	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super(name, age, isAlive);
		this.numberFins = numberFins;
	}

	public int getNumberFins() {
		return numberFins;
	}

	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
	}

	@Override
	public void speak() {
		System.out.println(this.getName() + " bubbles");
	}

}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
