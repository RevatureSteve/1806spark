package com.revature;
// POJO: Plain Old Java Object, aka no entry point.
// has state and behavior. aka methods and properties.
public class Person extends Object{
	
	//access modifiers/public: any developer can see and access
	//access modifiers/private: only reference private variables or methods from inside same class.
	
	//state: variables /variables at the instance level scope,( not static and not nested in methods. )
public String name;
public int age;
public double height;
public boolean isAlive;
public char gender;

// create a constructor: constructor takes in values to set the object's state.
// constructors follow very strict syntax
//		no return type, it returns the object.
//		the name is the same as the class.
//		can have any access modifier

public Person(){
	System.out.println("Making a person obj.");
}

// when method/constructor parameter have the same name as the instance variables: shadowing.
public Person(String name, int age, double height, boolean isAlive, char gender){
	
	this.name = name;
	this.age = age;
	this.height = height;
	this.isAlive = isAlive;
	this.gender = gender;
	System.out.println("Making a person obj. w parameters");
}

//Overloading: Constructors /Methods with the same name but different parameters inside the same class. **Interview Question**

//create a constructor w/ only age,name,height.
public Person(String name, int age, double height){
	super(); // the first line of every constructor is super() by default.
	this.name = name;
	this.age = age;
	this.height = height;
	
}


	//behavior: methods
	//when NOT returning anything, use void.
	public void walk(){
		System.out.println("I am walking");	
	};
	public String speak(){
		return "I am speaking.";
	}
	// Method Overriding: Changing the implementation of the parent's method: same name, same parameters.
	// note: you do not inherit constructors, so, you cannot override them.
	// @ means annotation.
	@Override
	public String toString() {
		return "Person [name=" + name +" , age="+age+", height" + height+ ", isAlive=" + isAlive  + ", gender=" + gender + "]";
	};
	
	
};
