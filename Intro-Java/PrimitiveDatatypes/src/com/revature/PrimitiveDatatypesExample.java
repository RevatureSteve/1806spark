package com.revature;

import com.revature.animals.Animal; // reference other java files like the require() in JavaScript

public class PrimitiveDatatypesExample {

	// entry point of the application
	public static void main(String[] args) {
//		primitives();
		
		// 2 classes found in the same package (folder) they can automatically be referenced without issue!
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true,'m'); // instantiated/created a Person object
		tom.name = "tom";
		Person bobbert = new Person("Bobbert",55,11); // another instantiated object of Person
		bobbert.name = "bobbert";
		
		System.out.println(tom.toString());
		System.out.println(bobbert);
		
		//Animal class is not found in com.revature but in com.revature.animals must use the import keyword!
		Animal a;
		
	}
	
	public static void primitives() {
		System.out.println("Hello Primitive");
		
		// primitive datatypes: data that can't be broken down
		// objects are made up of primitive datatypes, other objects and methods
		
		// Primitive datatypes in Java:
		char c = 'a'; // ' ' in java means a char, while " " are String (object)
		boolean b = true;
		boolean b1 = false;
		
		// All whole number, no decimal aka no floating point
		byte t = -128; // 1 byte: -128 to 127
		short s = 3; // 2-bytes: short
		int i = -2_147_483_648; //  4-bytes: integer: -2.1b
		long l = 300_000_000; //8-bytes: long _ is to allow the number to be read easier
		/*
		 *  float and double allow the use of a decimal .
		 *  	int does not
		 *  	
		 */
		float f1 = 10f; // float meaning there is a . (a decimal is need)
		float f2 = 10.2f;
		double d1 = 20.2; // double is twice the memory size of float
		double d2 = 40.45;
		
	}
	
}
