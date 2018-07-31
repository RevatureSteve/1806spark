package com.revature.fibonacci;


public class ReverseString {
	
	//main method
	public static void main(String[] args) {
		
		//input the string you want reversed
		String str = "Hello World";
		
		//our reverse result put into "reverseString(str)"
		String reverse = reverseString(str);
		//print out our reverse string
		System.out.println(reverse);
		
	}
	
	public static String reverseString(String str) {
		
		//declare 
		String result = "";
		
		//for loop 
		for (int i = (str.length() - 1); i >= 0; i--) {
			//result where it takes the last char and prints it in the front
			result = result + str.charAt(i);
			
		}
		return result;
	}

}
