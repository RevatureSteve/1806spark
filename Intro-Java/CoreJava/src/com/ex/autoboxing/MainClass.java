package com.ex.autoboxing;

public class MainClass {
	public static void main(String[] args) {
		
		
//		Every primitive datatype has a corresponding object, called a Wrapper Class.
		// int -> integer, char -> character, boolean -> Boolean
		// This is to allow primitive datatypes to be used as Objects.
		
		
		/*
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
		 */
		
		// boxing: primitive to Object
		int 	num1 = 5;
		Integer num2 = new Integer(num1);

		
		
		/*
<<<<<<< HEAD
		 * Unboxing: object to primitive.
	
=======
		 * Unboxing: Object to primitive
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		 */
		Integer num3 = new Integer(5);
		int 	num4 = num3.intValue();
		
		
		/*
		 * Autoboxing - Since Java 1.5
<<<<<<< HEAD
		 * automatically converts primitive to object without new keyword
=======
		 * 	automatically converts primitive to object without the new keyword
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
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
