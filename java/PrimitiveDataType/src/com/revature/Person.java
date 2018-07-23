package com.revature;

///POJO: PLAIN OLD JAVA OBJECT AKA NO ENTRY POINT BUT HAS A STATE AND BEHAVIOR
public class Person extends Object {
	
	/* 
	 * public and private access modifier
	 * public mean: any developer can access and see it
	 * 
	 * private: only reference variable or methods from inside the same class
	 *
	 * 
	 * 
	 */

	// state: variables at the instance level scope (not static and not nested in a method)
	public String name;
	public int age;
	public double height;
	public boolean alive;
	public char gender;
	private boolean isAlive;
	
	// create a constructor takes in the values the object's state
	//constructor follow strict syntax
	//          -no return type, it return only object
	//          -the name is the same of the class
	
	
	public Person(){
		System.out.println("making a person object with parameter");
		
	}
	
	public Person(String name, int age, double height, boolean isAlive, char gender){
		/// name dont have to match with the one declared up top
		this.name = name; 
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
		
		
		System.out.println("making a person object");
		
	}
	
	// create a constructor with only name, age, height
	
	public Person (String name, int age, double height ) {
		super(); // the first line of every constructor is super() by default!!
		this.name=name;
		this.age = age;
		this.height = height;
	}
	
	/*
	 * constructors/ method with the same name but different parameter inside the same class: overloading IQ
	 * 
	 */
	 
	

	// behavior method
	/**
	 * 
	 */
	public void walk() {
		// void not returning anything'
		System.out.println("i am walking");
	}

	public String speak() {
		return "i am speaking";
	}

	// method overriding : changing the implementation of the person method: same name and same parameter IQ
	// you do not .....
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", alive=" + alive + ", gender="
				+ gender + "]";
	}

	
}
