package com.revature;

import com.revature.animals.Animal; //reference other java files

public class PrimitiveDatatypesExample {
	
	public static void main(String[] args) {
		primitives();
		
//		packages in the same folder can be referenced without issue
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true, 'm'); //instantiated/created a person object
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 55, 11);
		bobbert.name= "Bobbert";
		
		
		System.out.println(tom.toString());
		System.out.println(bobbert);
//		animal class is not found in com.revature but is in com.revature.animals must use the import keyword!
		Animal a;
	}
	
	public static void primitives() {
		System.out.println("Hello Primitive");
//		primitive data types: data that can't be broken down
//		objects are made up of primitive datatypes, other objects and methods
//		primitive data types in Java: 
		char c = 'c';  // '' means a char "" are String (object)
		boolean b = true;
		boolean b1 = false;
		
		// alll whole numbers VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV
		byte t = 1; // byte: -128 to 127
		short s = 3; // 2 bytes
		int i = 2; //integer 4 bytes
		long l = 300_000_000; // _ is only to make it more readable
		
		float f = 10f;
		float f1 = 10.2f;  //float meaning there is a . (a decimal is needed)
		
		double d1 = 20.2;
		double d2 = 40.45; // double is twice the memory size of float
		
	}
	}


