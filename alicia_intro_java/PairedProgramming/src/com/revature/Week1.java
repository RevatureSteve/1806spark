package com.revature;

public class Week1 {
	
	public static void main(String[] args) {
		String str = reverseString("Hello");
		System.out.println(str);
	}
	
	
	public static String reverseString(String str) {
		char c;
		String reverseStr = "";
		for (int i = str.length()-1; i >= 0 ; i--) {
			c = str.charAt(i);
			reverseStr += c;
		}
		return reverseStr;
	}

	
	public static int fib(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fib(n-1) + fib(n-2);
		}
	}
	
}
