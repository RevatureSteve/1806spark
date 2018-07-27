package com.ex.operators;

/*
 * BITWISE OPERATORS
 * 
 * &	bitwise and
 * |	bitwise or
 * ^	bitwise xor
 * ~	bitwise compliment
 * <<	left shift
 * >>	right shift
 * >>>	zero fill right shift
 */
public class BitwiseOp {
	public static void main(String[] args) {
		
		byte x = 14; //00001110
		byte y = 7;  //00000111
		System.out.println(x & y); 	//00000110
		System.out.println(x | y); 	//00001111
		System.out.println(x ^ y);	//00001001
		System.out.println(x >> 2);	//00000011
		System.out.println(x >> 2);	//00000011
		System.out.println(x << 1);	//00011100
		
	}
}
