package com.revature.fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		//sets how many times to run through loop
		int n = 9;
		
		//Prints out array
		System.out.println(fib(n));
	}
	
	//fibonnaci sequence
	public static int fib(int n) {
		int f[] = new int[n + 2];
		int i;
		
		f[0] = 0;
		f[1] = 1;
		
		//i must be declared at 2 to account for the first 2 variables: 0 & 1
		for (i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		//returns the iterated array
		return f[n];
	}

}
