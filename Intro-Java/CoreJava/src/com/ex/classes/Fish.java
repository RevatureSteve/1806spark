package com.ex.classes;

<<<<<<< HEAD
public class Fish {

	private String name;	
	private int age;
	private boolean isAlive;
	private int numberFins;
	
	
	
	
=======
public class Fish extends Pet {
	private int numberFins;

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}
<<<<<<< HEAD
	
	
	public Fish(String name, int age, boolean isAlive, int numberFins) {
		super();
		this.name = name;
		this.age = age;
		this.isAlive = isAlive;
		this.numberFins = numberFins;
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
	public int getNumberFins() {
		return numberFins;
	}
	public void setNumberFins(int numberFins) {
		this.numberFins = numberFins;
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

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
