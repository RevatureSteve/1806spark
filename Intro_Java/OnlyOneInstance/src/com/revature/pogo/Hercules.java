package com.revature.pogo;

/*
 * Hercules is an object we want to restrict to only 1 instance: Singleton
 * 
 * What does a singleton require?
 * 		1. control the constructor(s) by encapsulating them with private
 * 		2. create static self reference (private static Hercules hercules)
 * 		3. public static get method for the self reference
 * 		4. create the state like an other pojo/javabean
 * 
 */

public class Hercules {
	
	//self reference to give to other classes
	private static Hercules hercules;//1. Scope? Class aka Static because of static keyword
	
	//provide hercules some state
	private String name; //2. Scope? Instance aka Object, not inside of a method and not static
	private int age;
	private boolean isAlive;

	private Hercules() {//3.set the name to "Hercules" in the constructor
		name = "Hercules";//this. is not required since we are not shadowing the name field
		age = 100;
		isAlive = true;
	}
	
	//provide a getHercules static method to give the only instance where needed
	public static Hercules getHercules() {
		if(hercules == null) {
			hercules = new Hercules();//call the constructor only once!
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
