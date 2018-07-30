package com.revature;

/** POJO Cat
 *  State, Behavior, NO-ARGS, override toString()
 * @author tyler
 *
 */
public class Cat {
	
	private String name;
	private String breed;
	public int age;
	
//every time you create a new instance variable ask-
	// do you need another constructor, getters and setters, or update your toString?
	
	public Cat() {}
	
	public Cat(String name, String breed) {
		super();
		this.name = name;
		this.breed = breed;
	}

	/*
	 * Getters and setters for name
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	/*
	 * Getters and setters for breed
	 */
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}


	/*
	 * override the toString for proper display of the state(variables) in a Sysout
	 */
	@Override
	public String toString() {
		return "Cat [name=" + name + ", breed=" + breed + "]";
	}
	
}
