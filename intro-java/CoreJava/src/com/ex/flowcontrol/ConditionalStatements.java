package com.ex.flowcontrol;

/*
 * RELATIONAL OPERATORS
 * 
 * ==	equal to
 * != 	not equal to
 * > 	greater than
 * < 	less than 
 * >= 	greater than or equal to
 * <= 	less than or equal to
 * 
 */

/*
 * LOGICAL OPERATORS
 * 
 * &&	logical and (short circuit)
 * ||	logical or (short circuit)
 * !	logical not
 */

/*
 * if
 * else if
 * else
 * switch
 */
public class ConditionalStatements {
	public static void main(String[] args) {

		int x = 10;
		int y = 20;

		if (x > 5) {
			System.out.println("x > 5");
		}

		if ((x > 5) && (x < 15)) {
			System.out.println("x is between 5 and 15 (exclusive)");
		}

		if (x == 8) {
			System.out.println("x == 8");
		} else if (x == 9) {
			System.out.println("x == 9");
		} else if (x == 10) {
			System.out.println("x == 10");
		} else if (x == 11) {
			System.out.println("x == 11");
		} else {
			System.out.println("didn't find x's value");
		}

		/*
		 * switch statement is good if testing many specific values
		 * 
		 * Java 1.7 introduced switch statement with String values
		 * 
		 * What happens if you don't include 'break' statement?
		 */
		switch (x) {
		case 8:
			System.out.println("x == 8");
			break;
		case 9:
			System.out.println("x == 9");
			break;
		case 10:
			System.out.println("x == 10");
			break;
		case 11:
			System.out.println("x == 11");
			break;
		default:
			System.out.println("didn't find x's value");
		}

	}
}
