package com.revature;

//import class com.revature.animals.Animal;//reference other java files like require()

public class PrimitiveDataTypesexample {

	// entry point of the application
	public static void main(String[] args) {
		//primitives();
		
		//2 classes found in the same pakage (folder) they can automatically 
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true, 'm');//instantiated a person object
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 55, 11);// another instantiation of a person object
		bobbert.name = "Bobbert";
		
		System.out.println("Name: " + tom.name);
		System.out.println("Name: " + bobbert.name);
		
		//animal class is not found in com.revature but in com.revature.animals must use the import key
		Animal a;
		
	}


	public static void primitives() {
		System.out.println("Hello Primitive!");

		// primitive datatypes: data that can't be broken down
		// objects are made up of primitive datatypes, other objects and methods

		// primitive datatypes in java:
		char c = 'c'; // in java means a char, while "" are Strings

		// all whole numbers
		byte t = 1;// 1 bytes -128 to 127
		short s = 3;// 2 bytes
		int i = 2; // 4 bytes integer
		long l = 300_000_000; // 8 bytes underscore allows for readability

		// float and double allow the use of a decimal .
		// int does not

		float f = 10f;// float meaning there is a . (a decimal is needed)
		float f1 = 10.2f;
		double d1 = 20.0;// double is twice the memory size of float
		double d2 = 40.45;

		boolean b = true;// no truthy or falsy when it comes to java
		boolean b1 = false;

	}
}


