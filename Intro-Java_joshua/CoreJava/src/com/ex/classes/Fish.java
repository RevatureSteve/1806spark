package com.ex.classes;

public class Fish {

	private String name;	
	private int age;
	private boolean isAlive;
	private int numberFins;
	
	
	
	
	public Fish() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
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
	
	
	
		
		
	
}