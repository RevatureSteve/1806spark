package com.ex.autoboxing;

public class MainClass {
	public static void main(String[] args) {
		
		
		//IQ
		
		
		//all primitive datatypes have corresponding object (int - Integer, double - Double, etc.) and it is called the wrapper classes. 
		// this allows primitive datatypes to be used as objects
		
		/*
<<<<<<< HEAD
		 * Boxing --- old way
=======
		 * 	Every primitive datatype has a corresponding object called Wrapper Classes
		 * 		int -> Integer
		 * 		char -> Character
		 * 		boolean -> Boolean
		 * 			etc.
		 * 
		 * 	This is to allow primitive datatypes to be used as Objects
		 */
		
		
		/*
		 * Boxing: primitive to Object (old way)
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		 */
		int 	num1 = 5;
		Integer num2 = new Integer(num1);

		
		
		/*
<<<<<<< HEAD
		 * Unboxing  -- object to primitive
=======
		 * Unboxing: Object to primitive
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		 */
		Integer num3 = new Integer(5);
		int 	num4 = num3.intValue();
		
		
		/*
<<<<<<< HEAD
		 * Autoboxing - Since Java 1.5 --- automatically converts primitive to object without the new keyword 
=======
		 * Autoboxing - Since Java 1.5
		 * 	automatically converts primitive to object without the new keyword
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		 */
		int 	num5 = 5;
		Integer num6 = num5;
		
		
		/*
		 * Auto Unboxing - Since Java 1.5
		 */
		Integer num7 = 5;
		int num8 = num7;
		
		
		
	}
}
