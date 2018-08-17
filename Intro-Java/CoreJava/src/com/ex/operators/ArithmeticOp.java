package com.ex.operators;

/*
 * ARITHMETIC OPERATORS
 * 
 * +	addition
 * -	subtraction
 * *	multiplication
 *\/	division
 * %	modulus (remainder of division)
 * ++	increment
 * --	decrement
 */
public class ArithmeticOp {
	public static void main(String[] args) {
		
		int x = 10;
		int y = 5;
		
		System.out.println("10 + 5: " + (x + y));
		System.out.println("10 - 5: " + (x - y));
		System.out.println("10 * 5: " + (x * y));
		System.out.println("10 / 5: " + (x / y));
		System.out.println("10 % 5: " + (x % y)); // 10/5 is 2 r 0
		System.out.println("10 % 4: " + (x % 4)); // 10/4 is 2 r 2
		
	}
}
