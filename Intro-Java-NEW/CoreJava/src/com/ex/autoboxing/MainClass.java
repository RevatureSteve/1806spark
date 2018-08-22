package com.ex.autoboxing;

public class MainClass {
	public static void main(String[] args) {
		/*
		 * every primitive datatype has a corresponding object
		 * int -> Integer
		 * char -> character
		 * boolean - > Boolean
		 * etc
		 * 
		 * this allows primitive datatypes to be used as Objects
		 */
		
		/*
		 * Boxing: primitive to Object (old way)
		 */
		int 	num1 = 5;
		Integer num2 = new Integer(num1);
		
		/*
		 * Unboxing: Object to primitive (old way)
		 */
		Integer num3 = new Integer(5);
		int 	num4 = num3.intValue();
		
		
		/*
		 * Autoboxing - Since Java 1.5
		 * 
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
