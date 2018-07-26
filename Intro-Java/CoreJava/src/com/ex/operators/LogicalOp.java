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
		System.out.println("true  && true:  " + (returnFalse() && returnTrue()));
		System.out.println("true  && false: " + (true && false));
		System.out.println("false && true:  " + (false && true));
		System.out.println("false && false: " + (false && false));
		System.out.println();

		System.out.println("|| LOGICAL OR (short circuit)");
<<<<<<< HEAD
		System.out.println("true  || true:  " + (true || true));
=======
		System.out.println("true  || true:  " + (returnTrue() || returnFalse()));
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
		System.out.println("true  || false: " + (true || false));
		System.out.println("false || true:  " + (false || true));
		System.out.println("false || false: " + (false || false));
		System.out.println();

<<<<<<< HEAD
		System.out.println("! LOGICAL NOT");
		System.out.println("!true:  " + (!true));
		System.out.println("!false: " + (!false));
		System.out.println();

		// BITWISE
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

	}


=======
//		System.out.println("! LOGICAL NOT");
//		System.out.println("!true:  " + (!true));
//		System.out.println("!false: " + (!false));
//		System.out.println();

		// BITWISE
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
	
	
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public static boolean returnTrue() {
		System.out.println("returnTrue called");
		return true;
	}
	
	public static boolean returnFalse() {
		System.out.println("returnFalse called");
		return false;
	}
}
