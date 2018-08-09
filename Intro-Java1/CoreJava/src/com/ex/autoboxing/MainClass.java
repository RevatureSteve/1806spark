package com.ex.autoboxing;

public class MainClass {
	public static void main(String[] args) {
		
		
		/*
		 * Every Primitive datatype has a corresponding object called Wrapper Classes
		 * 	int -> integer
		 *  char -> Character
		 *  boolean -> Boolean 
		 *  	etc.
		 *  This is to allow primitive datatypes to be used as Objects
		 */
		
		/*
<<<<<<< HEAD
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
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		 * Boxing: primitive to Object (old way)
		 */
		int 	num1 = 5;
		Integer num2 = new Integer(num1);

		
		
		/*
		 * Unboxing: Object to primitive
		 */
		Integer num3 = new Integer(5);
		int 	num4 = num3.intValue();
		
		
		/*
		 * Autoboxing - Since Java 1.5
		 * 	automatically converts primitive to object without the new keyword
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
