package com.revature;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
// POJO: Plain Old Java Object aka no entry point but has state/behavior
public class Person extends Object{

	/*
	 * public and private access modifier
	 *		public: any developer can see it
	 *		private: only reference private variables or methods from inside the same class
	 */
	
	// state: variables at the instance level (not static and not nested in a method)
=======
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
// POJO: plain old java object aka no entry point but has state/behavior
public class Person extends Object{

	/*
	 * 	public and private access modifier
	 * 		public: any developer can see it
	 * 		private: only reference private variables or methods from inside the same class
	 */
	
	// state: variables at the instance level scope (not static and not nested in a method)
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	
	
	// create a constructor: the constructor takes in the values to set the object's state
	//		constructors follow very strict syntax
	//			- no return type, it returns the object
	//			- the name is the same as the class
	//			- can have any access modifier
	public Person() {
		System.out.println("making a person object");
	}
					// when method/constructor parameter have the same name as the instance variables: shadowing
	public Person(String name, int age, double height, boolean isAlive, char gender) {
=======
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e

	
	// create a constructor: the constructor takes in the values to set the object's state
	// 		constructor follow very strict syntax
	//			- no return type, it returns the object
	//			- the name is the same as the class
	//			- can have any access modifier
	public Person(){
		System.out.println("making a person object");
	}
					// when method/constructor parameter have the same name as the instance variables: shadowing
	public Person(String name, int age, double height, boolean isAlive, char gender){
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
		this.gender = gender;
		System.out.println("making a person object w/ parameters");
	}
	/*
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	 * 	constructors/methods with the same name but different parameters inside the same class: overloading *possible interview question(IQ)
	 */
	// Create a constructor with only name, age, height
	public Person(String name, int age, double height) {
		super(); // first line of every constructor is super() by DEFAULT!
=======
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	 * 	constructors/methods with the same name but different parameters inside the same class: overloading IQ
	 */
	//Create a constructor with only name, age, height
	public Person(String name, int age, double height) {
		super(); // the first line of every constructor is super() by DEFAULT!!
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		this.name = name;
		this.age = age;
		this.height = height;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
	
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
	
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
	
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	// behavior: methods
	public void walk() {
		System.out.println("I am walking");
	}

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public String speak() {
		return "I am speaking";
	}

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	// method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// you do not inherit constructors so you cannot override them
	@Override // A means annotation
=======
	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// note you d not inherit constructors so you cannot override them
	@Override // @ means annotation 
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// note you d not inherit constructors so you cannot override them
	@Override // @ means annotation 
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// note you d not inherit constructors so you cannot override them
	@Override // @ means annotation 
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	
	

}
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
