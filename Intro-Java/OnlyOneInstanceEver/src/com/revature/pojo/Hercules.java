package com.revature.pojo;

/*
 * 
 * Hercules is an object we want to restrict to only 1 instance: Singleton
 * 
 * 
 * 	What does a singleton require?
 * 		1. Control the constructer(s) by encapsulating them private (Private constructor)
 * 		2. Create a self reference   (Create static self-reference)
 * 		3. provide a getHercules static method to give the only instance where needed
 * 		4. Create the state like any other pojo/javabean
 * 
 */



public class Hercules {
	
	//Create a self reference to give to another class
	private static Hercules hercules; // 1. Scope? Class scope

	
	//Provide Hercules some state
	private String name; // Scope? Instance/object, not inside of a method and not static
	private int age;
	private boolean isAlive;
	
	private Hercules() { // 3. set the name to "Hercules" in the constructer
		super();
		setName("Hercules");
		setAge(100);
		setAlive(true);
		
		
	}

	
	//Provide a getHercules static method to give the only instance where needed
	
	public static Hercules getHercules() {
		
		if(hercules == null) {
			hercules = new Hercules(); //Call the constructor only once
		}
			return hercules;
		
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
	

	
}
