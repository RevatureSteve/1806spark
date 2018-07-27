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
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		System.out.println("x = x + 2:\t" + x);
		
		int y = 5;
		y += 2; //translates into y = y + 2
		y += 10;
		System.out.println("y += 2:\t\t" + y);
		
		
	}
}
