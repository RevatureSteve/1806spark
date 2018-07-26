package com.ex.autoboxing;

public class MainClass {
	public static void main(String[] args) {
		
		
//		Every primitive datatype has a corresponding object, called a Wrapper Class.
		// int -> integer, char -> character, boolean -> Boolean
		// This is to allow primitive datatypes to be used as Objects.
		
		
		/*
		 * Boxing
		 */
		
		// boxing: primitive to Object
		int 	num1 = 5;
		Integer num2 = new Integer(num1);
		
		/*
		 * Unboxing: object to primitive.
	
		 */
		Integer num3 = new Integer(5);
		int 	num4 = num3.intValue();
		
		
		/*
		 * Autoboxing - Since Java 1.5
		 * automatically converts primitive to object without new keyword
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
