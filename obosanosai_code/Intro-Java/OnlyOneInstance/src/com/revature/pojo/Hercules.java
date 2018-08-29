package com.revature.pojo;

/*
 * Hercules is an object we want to restrict to only 1 instance: Singleton
 * 
 *      What does a singleton require?
 *         1. control the constructor(s) b encapsulating them with private (private constructor)
 *         2. static self reference line 13.
 *         3. public static get method for the self reference
 *         4. create the state/behavior like any other pojo/javabean
 *          
 *         
 */
public class Hercules {
	
	// Self reference to give to other classes
private static Hercules hercules; // 1. Scope? Static/class because the static keyword
	
// provide Hercules some state
private String name; // 2. Scope? instance aka object, not inside of a method and not static
private int age;      // ,,
private boolean isAlive; // ,,

	private Hercules() { //3. set the name to "Hercules" in the constructor, if the constructor(s) is private like this is, 
		//it means the class is a Singleton, it only invokes once, and if theres a "new" keyword 
		//it means the constructor has been called/invoked
		this.setName("Hercules"); // this. is not required since we are not shadowing the same field
		setAge(100);
		setAlive(true);
	}
	
	// provide a getHercules static method to give the only instance where needed
	public static Hercules getHercules() { // class/static because of the static keyword
		if(hercules==null) {
			hercules = new Hercules(); //call the constructor only once!
		}
		return hercules;
	}
// you need getters and setters because the states are private, you wouldn't need one if they were public
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
