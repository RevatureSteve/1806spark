package com.revature;

//POJO - Plain Old Java Object
//no entry point but has state and behavior 
public class Person {

	//public and private access modifier
		//public: any developer can see it
		//private: only reference privte variables or methods from inside the same class
	
	// state: variables
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
	
	//create a constructor: takes in the values to set the object's state
	//	constructor follow very strict syntax
	//		no return type, it returns the object
	//		the name is the same as the class
	public Person() {
		System.out.println("making a person object");
	}
	
	public Person(String name, int age, double height, Boolean isAlive, char gender) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
		System.out.println("making a person object");
	}
	
	//Method overloading constructors w/ same name but different parameters inside the same class IQ
	//create a constructor w/ name, age, type
	
	public Person(String name, int age, double height) {
		super();//first line of every constructor is super() by default!
		this.name = name;
		this.age = age;
		this.height = height;
	}
	// behavior: methods
	public void walk() {
		System.out.println("I am walking");
	}

	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// note: you do not inherit constructors, so cannot override them
	//@Override //@means annotations
	public String speak() {
		return "I am speaking";
	}

}
