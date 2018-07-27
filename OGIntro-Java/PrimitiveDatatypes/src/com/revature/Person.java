package com.revature;

<<<<<<< HEAD
//POJO: plain old java object aka no entry point but has state/behavior
public class Person extends Object {

	/*
	 * public and private access modifier
=======
// POJO: plain old java object aka no entry point but has state/behavior
public class Person extends Object{

	/*
	 * 	public and private access modifier
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	 * 		public: any developer can see it
	 * 		private: only reference private variables or methods from inside the same class
	 */
	
<<<<<<< HEAD
	
=======
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	// state: variables at the instance level scope (not static and not nested in a method)
	public String name;
	public int age;
	public double height;
	public boolean isAlive;
	public char gender;
<<<<<<< HEAD
	
	//create a constructor: the constructor takes in the values to set the object's state
	//		constructors follow very strict syntax
	//			-no return type, it returns the object
=======

	
	// create a constructor: the constructor takes in the values to set the object's state
	// 		constructor follow very strict syntax
	//			- no return type, it returns the object
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	//			- the name is the same as the class
	//			- can have any access modifier
	public Person(){
		System.out.println("making a person object");
	}
<<<<<<< HEAD
			// when method/constructor parameter have the same name as the instance variables: shadowing
=======
					// when method/constructor parameter have the same name as the instance variables: shadowing
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	public Person(String name, int age, double height, boolean isAlive, char gender){
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
<<<<<<< HEAD
		this.gender = gender;	
		System.out.println("making a person object w/ parameters");
	}
	//Create a constructor with only name, age, height
	
=======
		this.gender = gender;
		System.out.println("making a person object w/ parameters");
	}
	/*
	 * 	constructors/methods with the same name but different parameters inside the same class: overloading IQ
	 */
	//Create a constructor with only name, age, height
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	public Person(String name, int age, double height) {
		super(); // the first line of every constructor is super() by DEFAULT!!
		this.name = name;
		this.age = age;
		this.height = height;
	}
<<<<<<< HEAD

/*
 * constructors/ methods with the same name but different parameters inside the same class: overloading INTERVIEW QUESTION
 */
=======
	
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	
	// behavior: methods
	public void walk() {
		System.out.println("I am walking");
	}

<<<<<<< HEAD
	String speak() {
		return "I am speaking";
	}
	
	//method overriding: changing the implementation of a parent;s method: same name, same parameters
	// note you do not inherit constructors so you cannot override them 
	@Override // @ means annotation
=======

	public String speak() {
		return "I am speaking";
	}

	//method overriding: changing the implementation of a parent's method: same name and same parameters IQ
	// note you d not inherit constructors so you cannot override them
	@Override // @ means annotation 
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + ", gender="
				+ gender + "]";
	}
<<<<<<< HEAD

	
	
}


=======
	
	

}
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
