package com.revature;

// POJO: plain old java object. aka no entry point but has state/behavior
public class Person extends Object{
	
	// public and private access modifier
	//   Public: any developer can see it
	//   Private: only reference private variables or methods from inside the same class
	
	// state
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
	
	
	//create a constructor: the constructor takes in the values to set the object's state
	//	 constructors follow very strict syntax
	//		no return type, it returns the object
    //	    the name is the same as the class
	//		can have any access modifier
	public Person(){
		System.out.println("Making a person object");
	}
	public Person(String name, int age, double height, boolean isAlive, char gender){
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
		System.out.println("Making a person object");
	}

	public Person(String name, int age, double height){
		super(); // the first line of every constructor is super() by default
		this.name = name;
		this.age = age;
		this.height = height;
		System.out.println("Making a person object");
	}
	
	//constructors with the same name in the same class but with different parameters: overloading IQ

	// behavior: methods
	public void walk() {
		System.out.println("I am walking");
	}

	public String speak() {
		return "I am speaking";
	}
	
	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	//note you do not inherit constructors so you cannot override them
	@Override // @ means annotation
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", Gender="
				+ gender + "]";
	}
}
