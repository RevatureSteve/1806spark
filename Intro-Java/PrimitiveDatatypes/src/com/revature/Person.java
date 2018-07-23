package com.revature;

// POJO: plane old java object aka no entry point but has state and behavior
public class Person extends Object {
	// state: variables

	/*
	 * public and private modifiers public: any developer can access it private:
	 * only reference private variables or methods from in side the same class
	 */
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;

	// create a constructor: the constructor takes in the values to set the object's
	// state
	//	constructors have strict syntax
	//	-no return tyle
	//	-name is the same as the class
	//	-can have any access modifier
	public Person() {
		System.out.println("making a person object");
	}
	
	public Person(String name, int age, double height, boolean isAlive, char gender){
		System.out.println("making a person object");
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
	}
	/*
	 * constructors/methods with the same name but different parameters inside the same class overloading IQ
	 */
	public Person(String name, int age, double height) {
		super(); // first line of every constructor is super() by DEFAULT!!!
		System.out.println("making a person object");
		this.name = name;
		this.age = age;
		this.height = height;
	}
	// behavior: methods
	public void walk() {
		System.out.println("I am walking");
	}

	public String speak() {
		return "I am speaking";
	}

	@Override // @ means annotation
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}

}
