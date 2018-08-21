package com.revature;


/** 
 * 	POJO: Cat
 * 		-state 
 * 		-no-args constructor
 * 		-behavior
 * 		-override toString()
 */
public class Cat {

	private String name;
	private String breed;
	public int age;
	private boolean isFluffy;
	
	/*
	 *	Everytime you create a new instance variable like isFluffy
	 *		-do you need to add another constructor that takes isFluffy?
	 *		-do you need getters and setters?
	 *		-do you need to update your toString()?
	 */
	
	
	public Cat() {}

	public Cat(String name, String breed) {
		super();
		this.name = name;
		this.breed = breed;
	}

	public Cat(String name, String breed, int age, boolean isFluffy) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.isFluffy = isFluffy;
	}

	/*
	 * 	Getters and Setters for name
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * 	Getters and Setters for breed
	 */
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	
	public boolean isFluffy() {
		return isFluffy;
	}

	public void setFluffy(boolean isFluffy) {
		this.isFluffy = isFluffy;
	}
	
	/*
	 * 	override the toString for proper display of the state(variables) in a Sysout
	 */
	@Override
	public String toString() {
		return "Cat [name=" + name + ", breed=" + breed + ", isFluffy=" + isFluffy + "]";
	}



	
	
}
