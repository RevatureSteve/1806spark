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
<<<<<<< HEAD
=======
	
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	public static void main(String[] args) {
		
		int a = 10;
		int b = 10;
		int c = 10;
		int d = 10;
		
		printInt(a++);
<<<<<<< HEAD
		printInt(++b);

		System.out.println("10++: "  + (a++) + "\t" + a); //evaluated then incremented
		System.out.println("++10: "  + (++b) + "\t" + b); //incremented then evaluated
		System.out.println("10--: "  + (c--) + "\t" + c); //evaluated then decremented
=======
		System.out.println(a);
		printInt(++b);
		System.out.println(b);

		System.out.println("10++: "  + (a++) + "\t" + a + "\n"); //evaluated then incremented
		System.out.println("++10: "  + (++b) + "\t" + b); //incremented then evaluated
		System.out.println("10--: "  + (c--) + "\t" + c + "\n"); //evaluated then decremented
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("--10:  " + (--d) + "\t" + d); //decremented then evaluated
	}
	
	static void printInt(int x){
		System.out.println("x: " + x);
	}
}




