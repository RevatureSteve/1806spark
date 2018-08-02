package com.revature.pojo;


/*
 * Hercules is an object we want to restrict to only 1 instance: Singleton
 * 	
 * 		What does a singleton require?
 * 			1. control the constructor by encapsulating them w/ private
 * 			2. static self reference line 13. 
 * 			3. public static get method for the reference 
 * 			4. create the state/behavior like any other pojo/javabean 
 * 
 */
public class Hercules {
	
	//self reference to give to other classes
	private static Hercules hercules; //1. scope? a: class aka static b/c of the static keyword 
	
	private String name; // 2. scope? a: instance aka object, not inside of a method and not static
	private int age;
	private boolean isAlive; 
	
	
	private Hercules() { //3. set the name to "Hercules" in the constructor 
		setName("Hercules"); //"this.name" is not required since we are not shadowing the name field
		setAge(100);
		setAlive(true);
	}
	
	//provide a getHercules static method to give the only instance where needed
	public static Hercules getHercules() {
		if(hercules == null) {
			hercules = new Hercules(); //call the constructor once!
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
