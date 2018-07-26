package com.revature;


public class PrimitiveDataTypeExample {
	//main method is entry point of the application
	
	public static void main(String[] args) {
		System.out.println("Hello Primitive Data");
//		primitives();
		
		// 2 classes in not found in the same package(folder) they can automatically be referenced without issue!
		Person p;
		Person tom = new Person(); //instantiated / created a person object
		tom.name = "TOM";
		Person bobbert = new Person(); //another instantiated object of person
		bobbert.name = "Bobbert";
		
		System.out.println("Name :"  + tom.name);
		System.out.println("Name : " + bobbert.name);
		
		// animal is not the same class 
	}
		
		
		public static void primitives() {
		
		// primitive data type: data that cannot be broken down
		// objects are made up of primitive data type, other objects and methods
		
		//primitive data type in java;
		
		char c = 'c'; // '' single quote mean char, while " " quote are string (object)
		boolean b = true;
		boolean b1 = false;
		
		
		// all whole number 
		byte t = 1; // 1 byte  -128 to 128
		short s = 3; // 2 byte
		int i = 5; // integer // 4 byte
		long l = 300_000_000; // 8byte // underscore just allow it to be more readable 
		
		
		/*
		 * float and double allow the use of decimal.
		 * 
		 * int dont allow such
		 * 
		 * */
		
		float f1 = 10f; // float meaning there is a decimal 
		float f2 = 10.5f; 
		
		double d1 = 20.5; //double is twice as large as float
		double d2 = 40.2; 
		
		
	}

}
