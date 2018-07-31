package com.revature;

import com.revature.animals.Animal;

public class PrimitiveDatatypes {
	
	//Entry point of the application
	public static void main(String[] args) {

		Person p;
		Person tom = new Person("Tom", 45, 10.5, true, 'm'); //Instantiated/created a person object
		tom.name = "Tom";
		Person bobbert = new Person("Bobbert", 55, 11.0); //Instantiated/created a person object
		bobbert.name = "Bobbert";
		
		System.out.println("Name: " + tom.toString());
		System.out.println("Name: " + bobbert);
		
		//Anima class is not found in com.revature, but in com.revature.animals... must use import keyword
		Animal a;
	}
	
	public static void primitives() {	

		//Objects are made up of primitive datatypes, other objects, and methods
		
		//Primitive Datatypes in Java
		char c = 'c'; // ' ' in java means a char, while ' ' are String (object)
		int i = 2; //integer... 4-bytes
		float f = 10f; // float meaning there is a . (a decimal is needed)
		double d1 = 10.2; // double is twice the memory size as float
		double d2 = 40.45;
		boolean b = true; 
		boolean b1 = false; 
		byte t = 1;
		short s = 3; //2-bytes
		long l = 300_000_000; //underscore to make it more readable    8-bytes
		
		//All whole numbers, no decimal aka no floating point
		//int 
		//short
		//long
		//byte 
	}
		
	
	
	

}
