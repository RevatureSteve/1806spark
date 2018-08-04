package com.revature;

public class Driver {
	
	public static void main(String[] args) {
			
		System.out.println(fib(3));
		System.out.println(reverse("WATER"));
	}
	
	public static int fib(int num) {
		
		if (num <=1){ 
			return 1;}
		else {
			return fib(num-1) + fib(num-2); // return gives back a value
			
			
			
		}
				
		
		
		
	}
	
	public static String reverse(String name) { // Returning the reverse of a given string
		char c; // creating a character variable
		String dumb = ""; // creating an empty string
		for (int i = name.length() - 1; i >= 0 ; i--) { // for every time that variable i is greater than the first letter in the string (0), move on to the next letter
			c = name.charAt(i); //return the character value at index i
			dumb = dumb + c; // concatenates dumb and c together
		}
		
		
		
		return dumb; //then return the value of dumb
		
		
		
	}
	
}

