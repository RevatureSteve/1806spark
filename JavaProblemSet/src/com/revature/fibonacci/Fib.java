package com.revature.fibonacci;


public class Fib {
	
	public static void main(String[] args) {
		
		//declare how many times it runs through the for loop
		int n = 6;
		
		//prints out the value 
		System.out.println(fib(n));
	}
	
	//actual fibonacci sequence
	static int fib(int n) {
		
		
		int f[] = new int[n+2];
		int i;
		
		f[0] = 0;
		f[1] = 1;
		
		//"i" must be declared at 2 to account for the first 2 variables: 0 & 1
		for (i = 2; i <= n; i++) {
			
			//the fibonacci sequence equation
			f[i] = f[i-1] + f[i-2];
			
			//this is the sequence after each iteration
			System.out.println(f[i]);
		}
		return f[n];
	}

}
