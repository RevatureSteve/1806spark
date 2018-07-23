package com.revature;

import com.revature.animals.Animal;

public class PrimitiveDatatypesExample {

	public static void main(String[] args) {
		
		//classes in the same package can be automatically referenced with no issue
		Person p;
		Person tom = new Person("Tom", 23, 7, true, 'm');
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 55, 4.5);
		bobbert.name = "Bobbert";
		
		System.out.println("Name: " + tom.toString());
		System.out.println("Name: " + bobbert.toString());
		
		//not found in com.revature but in com.revature.animals must use the import keyword
		Animal a = new Animal();		
	}

	public static void primitives() {
		System.out.println("Hello Primitive");

		// primitive datatypes: data that can't be broken down
		// objects are made up of primitive datatypes, other objects and methods

		// primitive datatypes
		char c = 'c'; // single quotes in java means a char

		boolean b = true;
		boolean b1 = false;

		byte t = 1; // byte
		short s = 3; // short
		long l = 300_000_000; // underscore allows readability

		int i = 0;

		// float and double allow the use of decimals
		float f = 10f; // float meaning there is a . (a decimal is needed)
		float f1 = 10.2f;
		double d1 = 20.2;// double is twice the memory size of float
		double d2 = 40.45;
	}

}
