package com.revature.pojo;
/*
 * Hercules is an object we want to restrict to only 1 instance: Singleton
 * 
 * A singleton Requires:
 * 		control the constructor(s) by encapsulation them with private
 * 		static self reference line 13
 * 		public static get method for the reference
 * 		create the state like any other pojo/javabean
 * 		
 * 
 * private constructor is the best giveaway that this is a singleton, 
 * then within the class you must be calling the new keyword somewhere
 * 
 * A constructor will always have the same name as the class, a constructor shows no return type
 * 
 * multiple constructors is constructor overloading, they would all have to be private
 * 
 * encapsulated- think set it to private and get getters and setters. when private state, 
 * getters and setters is the only way to access that class
 * 
 * 
 */


public class Hercules {
	
	//Self reference to give other classes
	private static Hercules hercules;  // 1. Scope? - Class aka static because the static keyword static=class scoped
	
	private String name; //2. Scope? Instance aka object, not inside of a method and not static
	private int age;
	private boolean isAlive;
	
	
	private Hercules() {   //3. set the name to "Hercules" in the constructor
		
		this.setName("Hercules:");  //this. is not required since we are not shadowing the name field
		setAge(100);
		setAlive(true);
		
		
	}

	//Provide a getHercules static method to give the only instance where needed
	public static Hercules getHercules() {
		if(hercules == null) {
			hercules = new Hercules(); //call the constructor only once
		}
		return hercules;
		
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hercules [name=" + name + ", age=" + age + ", isAlive=" + isAlive + "]";
	}
	
}
