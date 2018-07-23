package com.ex.operators;

/*
 * ARITHMETIC OPERATORS
 * 
 * +	addition
 * -	subtraction
 * *	multiplication
 *\/	division
 * %	modulus
 * ++	increment
 * --	decrement
 */
public class ArithmeticIncrementOp {
	public static void main(String[] args) {
		
		int a = 10;
		int b = 10;
		int c = 10;
		int d = 10;
		
		printInt(a++);
		printInt(++b);

//		System.out.println("10++: "  + (a++) + "\t" + a); //evaluated then incremented
//		System.out.println("++10: "  + (++b) + "\t" + b); //incremented then evaluated
//		System.out.println("10--: "  + (c--) + "\t" + c); //evaluated then decremented
//		System.out.println("--10:  " + (--d) + "\t" + d); //decremented then evaluated
	}
	
	static void printInt(int x){
		System.out.println("x: " + x);
	}
}




