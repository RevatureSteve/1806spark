package com.revature;

//POJO: plain old java object aka no entry point but has state/behavior : methods/properties
public class Person extends Object{
	
// public and private access modifier- public any developer can see it, private: only reference private variables or methods from inside the same class

	//state: variables at the instance level (not static and not nested inside of a method
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
	
//	Create a constructor: the constructor takes in the values to set the object's state
//	constructors follow very strict syntax
//	constructors have no return type, it returns the object
//	the name is the same as the class, it can have any access modifier
	public Person (){
		System.out.println("Making a person object");
		}
	public Person (String name, int age, double height, boolean isAlive, char gender){
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
//		when method/constructor parameter have the same name as teh instance variables: shadowing
		
		System.out.println("Making a person object");
	}
//	create a constructor with only name, age, and height  source> generate constructor using fields>
//	constructors/methods with the same name but different parameters inside the same class is overloading
	
public Person(String name, int age, double height) {
	super();
	this.name = name;
	this.age = age;
	this.height = height;
}
//	behavior: methods
	public void walk(){
		System.out.println("I am walking");
	}
	
	public String speak(){
		return "I am speaking";
	}

	@Override //@ means annotation    ---correctly overriding parent
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}
	
	
}
