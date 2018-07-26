package com.revature;

import com.revature.animal.Animal; // reference other java files like the require() in JavaScript

public class PrimitiveDatatypesExample {

	public static void main(String[] args) {
//		primitives();
		
		// 2 classes found in the same package (folder) they can automatically be referenced 
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true, 'm'); // instantiated a Person object
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 55, 11); // another instantiated object of Person
		bobbert.name = "Bobbert";
		
		System.out.println(tom.toString());
		System.out.println(bobbert);
		
		// Animal class is not found in com.revature but in com.revature.animals must use the import keyword!
		Animal a;
		
	}
	
	
	
	
	public static void primitives() {
		System.out.println("Hello Primitive");
		
		// primitive datatypes: data that can't be broken down
		//Objects are made up of primitive datatypes, other objects and methods
		
		//Primitive datatypes in Java:
		char c = 'c'; // ' ' in java means a char, while " " are String (object)
		boolean b = true;
		boolean b1 = false;
		
		// all whole number, no decimal aka no floating point
		byte t = 1; //byte: -128 to 127
		short s = 3; // 2-bytes: short
		int i = 2; // 4-bytes: integer
		long l = 300_000_000; // 8-bytes: long _ is to allow the number to be read easier
		
		/*
		 * float and double allow the use of a decimal .
		 * 		int does not
		 */
		float f1 = 10f; // float means there is a . (a decimal is need)
		float f2 = 10.2f;
		
		double d1 = 20.2; // double is twice the memory size of float
		double d2 = 40.45;
	}
}
