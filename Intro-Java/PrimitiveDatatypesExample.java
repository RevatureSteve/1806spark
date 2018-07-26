package com.revature;

import com.revature.animals.Animal; //reference other java files like the require() Javascript

public class PrimitiveDatatypesExample {

	
	
	public static void main(String[] args) {
//	primitives();
		
		// 2 classes found in the same package (folder) they can automatically be referenced without issue
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true, 'm');  // instantiated/created a Person object
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 56, 10.5); // another instantiated object of Person
		bobbert.name = "Bobbert";
		
		System.out.println(tom.toString());   // this line and next are doing the same thing
		System.out.println(bobbert);  
		
		
		
		//Animal class is not found in com.revature but in com.revature.animals must use the import keyword.
		Animal a;
	}
	
	
	
	//entry point
	public static void primitives() {
		System.out.println("Hello Primitive");
		
		// primitive datatypes: data that can't be broken down
		// objects are made up of primitive datatypes, other objects and methods
		
		//primitive datatypes in Java;
		char c = 'c'; // '' in java means a char, while " " are String (object)
		
		boolean b = true;
		boolean b1 = false;
		
		
		//all whole numbers, no decimal aka floating point
		byte t = 1; // 1 byte: -128 - 127 
		short s = 3; //2 bytes: short
		int x = 5; // 4 bytes: integer    -2.1billion
		long l = 300000000; // _ is to allow the number to be read easier
		
		
		
		/*  float and double allow the use of a decimal .
		 * 		int does not
		 * 
		 */
		float f1 = 10f;
		float f2 = 10.2f; // float meaning there is a . (a decimal is needed)
		double	d1 = 20.2; // double is twice the memory size of float
		double d2 = 40.45; 
		
				
	}
}
