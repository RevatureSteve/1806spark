package com.revature;

import com.revature.animal.Animal; // reference other java files like the require() in javascript

public class PrimitiveDatatypesExample {
	public static void main(String[] args) {
		// primitives();

		// 2 classes found in the same package they can automatically be referenced
		// without issue;
		Person p;
		Person tom = new Person("Tom", 45, 6.5, true, 'm'); // instantiated/created a Person object
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 15, 5.2); // another instantiated object of Person
		bobbert.name = "Bobbert";

		System.out.println("Name: " + tom.toString());
		System.out.println("Name: " + bobbert);

		// Animal class is not found in com.revature but in com.revature.animal. must
		// use the import keyword!
		Animal a;
	}

	public static void primitives() {
		System.out.println("Hello Primitives!");

		// primitive datatypes: data that cant be broken down
		// objects are made up of primitive datatypes, other objects and methods

		// Primitive datatypes in Java:
		char c = 'c'; // ' ' in Java means a char, while " " are for Strings (object)
		boolean b = true;

		byte t = 122; // -128 to 127 1 byte
		short s = 3; // 2 byte
		int i = 2; // integer 4 byte
		long l = 300_000_000; // _ is to allow the number to be read easier 8 byte

		float f = 10f; // float meaning there is a . (a decimal is needed
		double d = 10.2; // double is twice the memory size of float
	}
}