package com.revature;

import com.revature.animals.Animal; //requiring use. reference other java files.

public class PrimitiveDatatypesExample {

	// this is the entry point of the application.
	public static void main(String[] args) {
		
		// 2 classes found in the same package (com.revature in this case) 
		// can be automatically referenced w/o issues.
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true, 'M'); //instantiated/created a Person object.
		tom.name = "tom";
		Person bobbert = new Person("Bobbert", 45, 15); //another instantiation of a Person obj.
		bobbert.name = "bobbert";
		
		System.out.println(tom);
		System.out.println(bobbert);
		
		// ANIMAL CLASS IS NOT FOUND IN COM.REVATURE, BUT, COM.REVATURE.ANIMALS.
		// MUST USE THE IMPORT KEYWORD.
		Animal a;
		
//		primitives(); // this will allow you to invoke your program.
	}
	
	public static void primitives() {
System.out.println("Hello Primitive.");
		
		//primitive datatypes: data that cannot be broken down anymore.
		//objects are made up of primitive datatypes, other objects, and methods.
		
		// Primitive datatypes in Java:
		char c = 'c'; // '' in Java mean a char, while "" are String(object);
		
		boolean b = true;
		boolean b1 = false;
		
		// All whole numbers, no decimal aka no floating points.
		byte t = 1; //1 byte: -128 to 127 
		short s = 3; //2 byte short
		int i = 2; // integers are whole numbers only // 4 byte-integer
		long l = 300_000_000; // long 8 bytes
		// _ is to allow the number to be read easier.
		
		float f = 10.5f; // float means there is a decimal, allows for mixed numbers.
		double d1 = 20.2; //double is twice the memory size of float, same purpose.
		double d2 = 40.45;
	}
	
	
	
	
}
