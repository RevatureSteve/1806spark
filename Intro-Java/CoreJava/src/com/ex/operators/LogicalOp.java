package com.ex.operators;

/*
 * BITWISE OPERATORS (that can also be used as logical operators)
 * 
 * &	bitwise and
 * |	bitwise or
 * ^	bitwise xor
 */

/*
 * LOGICAL OPERATORS
 * 
 * &&	logical and (short circuit)
 * ||	logical or (short circuit)
 * !	logical not
 */

/*
 * SHORT CIRCUIT OPERATOR
 * If the result can be determined by the first operand, the second operand is never evaluated
 */
public class LogicalOp {
	public static void main(String[] args) {

		// LOGICAL
		System.out.println("&& LOGICAL AND (short circuit)");
<<<<<<< HEAD
		System.out.println("true  && true:  " + (returnFalse() && returnTrue()));
=======
		System.out.println("true  && true:  " + (true && true));
>>>>>>> master
		System.out.println("true  && false: " + (true && false));
		System.out.println("false && true:  " + (false && true));
		System.out.println("false && false: " + (false && false));
		System.out.println();

		System.out.println("|| LOGICAL OR (short circuit)");
		System.out.println("true  || true:  " + (returnTrue() || returnFalse()));
		System.out.println("true  || false: " + (true || false));
		System.out.println("false || true:  " + (false || true));
		System.out.println("false || false: " + (false || false));
		System.out.println();

//		System.out.println("! LOGICAL NOT");
//		System.out.println("!true:  " + (!true));
//		System.out.println("!false: " + (!false));
//		System.out.println();

		// BITWISE
<<<<<<< HEAD
//		System.out.println("& BITWISE AND");
//		System.out.println("true  & true:  " + (true & true));
//		System.out.println("true  & false: " + (true & false));
//		System.out.println("false & true:  " + (false & true));
//		System.out.println("false & false: " + (false & false));
//		System.out.println();
//
//		System.out.println("| BITWISE OR");
//		System.out.println("true  | true:  " + (true | true));
//		System.out.println("true  | false: " + (true | false));
//		System.out.println("false | true:  " + (false | true));
//		System.out.println("false | false: " + (false | false));
//		System.out.println();
//
//		System.out.println("^ BITWISE XOR");
//		System.out.println("true  ^ true:  " + (true ^ true));
//		System.out.println("true  ^ false: " + (true ^ false));
//		System.out.println("false ^ true:  " + (false ^ true));
//		System.out.println("false ^ false: " + (false ^ false));
//		System.out.println();

	}
	
	public static boolean returnTrue() {
		System.out.println("!retrunTrue has been called!");
		return true;
	}
	
	public static boolean returnFalse() {
		System.out.println("returnFalse has been called");
		return false;
=======
		System.out.println("& BITWISE AND");
		System.out.println("true  & true:  " + (true & true));
		System.out.println("true  & false: " + (true & false));
		System.out.println("false & true:  " + (false & true));
		System.out.println("false & false: " + (false & false));
		System.out.println();

		System.out.println("| BITWISE OR");
		System.out.println("true  | true:  " + (true | true));
		System.out.println("true  | false: " + (true | false));
		System.out.println("false | true:  " + (false | true));
		System.out.println("false | false: " + (false | false));
		System.out.println();

		System.out.println("^ BITWISE XOR");
		System.out.println("true  ^ true:  " + (true ^ true));
		System.out.println("true  ^ false: " + (true ^ false));
		System.out.println("false ^ true:  " + (false ^ true));
		System.out.println("false ^ false: " + (false ^ false));
		System.out.println();

>>>>>>> master
	}
	
	
	public static boolean returnTrue() {
		System.out.println("returnTrue called");
		return true;
	}
	
	public static boolean returnFalse() {
		System.out.println("returnFalse called");
		return false;
	}
}
