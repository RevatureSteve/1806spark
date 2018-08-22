package com.revature.fibonacci;

public class Fibonacci {
	static int fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		} else if (n < 0) {
			return fib(n + 2) - fib(n + 1);
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static void main(String[] args) {
		int n = 8;
		System.out.println(fib(n));
	}
}