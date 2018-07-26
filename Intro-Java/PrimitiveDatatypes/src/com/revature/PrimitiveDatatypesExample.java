package com.revature;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.revature.animals.Animal; // reference other Java files like the require() in JS
=======
import com.revature.animals.Animal; // reference other java files like the require() in JavaScript
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
import com.revature.animals.Animal; // reference other java files like the require() in JavaScript
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
import com.revature.animals.Animal; // reference other java files like the require() in JavaScript
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e

public class PrimitiveDatatypesExample {

	// entry point of the application
	public static void main(String[] args) {
//		primitives();
		
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		// 2 classes found in the same package (folder) they can automatically be referenced without any issue
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true, 'm'); // instantiated/created a Person object
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 55, 11); // another instantiated object of Person
		bobbert.name = "Bobbert";
=======
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		// 2 classes found in the same package (folder) they can automatically be referenced without issue!
		Person p;
		Person tom = new Person("Tom", 45, 10.5, true,'m'); // instantiated/created a Person object
		tom.name = "tom";
		Person bobbert = new Person("Bobbert",55,11); // another instantiated object of Person
		bobbert.name = "bobbert";
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		
		System.out.println(tom.toString());
		System.out.println(bobbert);
		
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
		// Animal class is not found in com.revature but in com.revature.animals. Must use the import keyword
		Animal a;
	}

	public static void primitives() {
		System.out.println("Hello Primitive");

		// primitive datatypes: data that can't be broken down
		// objects are made of primitive datatypes, other objects, and methods

		// Primitive datatypes in Java:
		char c = 'c'; // ' ' in Java means a char, while " " are String (object)
		boolean b = true;
		boolean b1 = false;

		// All whole numbers, no decimal aka no floating point
		byte t = -128; // 1 byte: -128 to 127
		short s = 3; // 2-bytes: short
		int i = 2; // 4-bytes: integer
		long l = 300_000_000; // 8-bytes: long _ is to allow the number to be read easily

		/*
		 * float and double allow the use of a decimal int does not
		 */

		float f1 = 10f; // float meaning there is a . (a decimal is needed)
		float f2 = 10.2f;
		double d1 = 20.2; // double is twice the memory size of float
		double d2 = 40.45;
	}
=======
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
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
	
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
