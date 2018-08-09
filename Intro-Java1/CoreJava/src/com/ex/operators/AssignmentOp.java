package com.ex.operators;

/*
 * ASSIGNMENT OPERATORS
 * 
 * = += -= *= /= %= <<= >>= &= ^= |=
 */
public class AssignmentOp {
	public static void main(String[] args) {
		
		int x = 5;
<<<<<<< HEAD
		x = x + 2; // assignment operator is evaluated last!
=======
		x = x + 2; // = assignment operator is evaluated last!
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("x = x + 2:\t" + x);
		
		int y = 5;
		y += 2; //translates into y = y + 2
		y += 10;
		System.out.println("y += 2:\t\t" + y);
		
		
	}
}
