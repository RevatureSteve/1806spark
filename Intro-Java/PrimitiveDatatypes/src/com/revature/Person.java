package com.revature;


//POJO: plain old java object aka no entry point, but has state/behavior
public class Person extends Object{
	
	//Public access modifier: any developer can see it
	// Private access modifier: only reference private variables or methods from inside the same class
	
	//state= variables; instance level variables (not static and nested in a method)
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
	
	
	// Create a constructor: The constructor takes in the values to set to the object's state
	// Constructors follow very strict syntax
	// 			- no return type. It returns the object
	//			- the name is the same as the class
	//			- Can have any access modifier
	
	public Person(){
		
		System.out.println("Making a person object");
		
	}
			//When method/constructor parameter have the same name as the instance variables: shadowing
	public Person(String name, int age, double height, boolean isAlive, char gender){
		//The first line of every constructor is super() by DEFAULT
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
		System.out.println("Making a person object w/ parameters");
		
	}
	/*
	 * 
	 * Constructors/methods with the same name but different parameters inside the same class: overloading IQ
	 */
	
	// Create a constructor with only name,age height
	
	public Person(String name, int age, double height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
	
	
	//behavior = methods
	
	public void walk(){
		System.out.println("I am walking");
		
	}

	public String speak(){
		
		return "I am speaking";
	}

	@Override //means annotation
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}
	
	
	

}
