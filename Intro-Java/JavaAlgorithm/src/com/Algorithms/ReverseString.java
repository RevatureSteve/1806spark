package com.Algorithms;

import java.util.Scanner;

public class ReverseString {
	public static void main(String[] args) {
		System.out.println("Enter string to reverse: ");
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		StringBuilder sb = new StringBuilder(str);
		
		System.out.println("Reversed string is:");
		System.out.println(sb.reverse().toString());
	}
}
