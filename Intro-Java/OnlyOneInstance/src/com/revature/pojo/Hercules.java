package com.revature.pojo;

/*
 * 	Hercules is an object we want to restrict to only 1 instance: Singleton
 * 
 * 		What does a singleton require?
 * 			1. control the constructor(s) by encapsulating them with private
 * 			2. static self reference
 * 			3. public static get method for the self reference
 * 			4. create the state/behavior like any other pojo/javabean
 */
public class Hercules {
	
	//	Self reference to give to other classes
	private static Hercules hercules; // 1. Scope -Class aka static because the static keyword
	
	//	provide Hecules some state
	private String name; //	2. Scope? instance, not inside of a method and not static
	private int age;
	private boolean isAlive;
	
	
	private Hercules() {	//3. set the name to "Hercules" in the constructor
		this.setName("Hercules"); //this. is not required since we are not shadowing the name field
		setAge(100);
		setAlive(true);
	}
	
	//provide a getHercules static method to give the only instance where needed
	public static Hercules getHercules() {
		if(hercules == null) {
			hercules = new Hercules(); //	call the constructor only once
		} //private constructor requires new
		return hercules;
	}
	//you need getters and setters for private states
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

	@Override
	public String toString() {
		return "Hercules [name=" + name + ", age=" + age + ", isAlive=" + isAlive + "]";
	}
	
}
