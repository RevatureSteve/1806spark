package com.reverse.string;

public class ReverseString {

	public static void main(String[] args) {
		String name= "marcin";
		String reverse = "";
		
		for (int r=0; r < name.length(); r++) {
			
			 reverse =  name.substring(r, r+1) + reverse  ;
		}
			System.out.println(reverse);
	

	} 
	
}
