package com.revature;

public class Driver {

	public static void main(String[] args) {
		//string to be reversed
		String str = "Chicken";

		//sets result of method to a variable
		String reverse = reverseString(str);

		//Prints out reverse string
		System.out.println(reverse);
	}

	//Method to reverse string
	public static String reverseString(String str) {
		//Initializing new string to hold reverse string
		String result = " ";

		//loop adds chars to string result starting from the last index to the beginning index
		for (int i = (str.length() - 1); i >= 0; i--) {
			result = result + str.charAt(i);
		}
		
		//returns result of reversed string
		return result;
	}

}
