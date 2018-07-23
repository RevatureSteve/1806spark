package com.revature;

// POJO: plain old java object aka no entry point but has state/behavior 
public class Person extends Object {  // last part was already there, but just writing it out	
	/*
	 * public and private access modifier
	 * 	public: any developer can see it
	 * private: only reference private variables or methods from inside the same class 
	 */

	// state: variables at the instance level (not static and not nested in a method)
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
	
	//create a constructor!: the constructor takes in the values to set the object's state
	//     constructor follow very strict syntax 
	//		- no return type, it returns the object
	//		-the name is the same as the class
	//		-can have any access modifier
	
	public Person(){
		System.out.println("making person object");
		
	}
	
			//when method/constructor parameter have the same name as the instance variables: shadowing
	public Person(String name, int age, double height, boolean isAlive, char gender){
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
		System.out.println("making person object");
		
	}
	
	
	/*
	 * constructors/methods with the same name but different parameters inside same class: overloading IQ
	 */
	//create a constructor with only name, age, height
	public Person(String name, int age, double height){
		super(); //first line of every constructor is implicitly super() by DEFAULT
		this.name = name;
		this.age = age;
		this.height = height;
		System.out.println("making person object");
		
	}
	


	// behavior: methods
	public void walk() {
		System.out.println("I am walking");
	}

	public String speak() {
		return "I am speaking";
	}

	//method overriding: changing the implementation of a parent's method: same name same parameters. 
	//Can't inherit constructors so you cannot override them IQ
	@Override //@ means annotation
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}
	
	
}
