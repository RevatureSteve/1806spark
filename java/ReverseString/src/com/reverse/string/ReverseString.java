package com.reverse.string;

public class ReverseString {

	public static void main(String[] args) {
		String name= "marcin";
		//String name1= "marcin";
		String reverse = "";
		//String reverse1 = "";
		
		for (int r=0; r < name.length(); r++) {
			//for (int m= 0; m<name1.length(); m++) {
			//	 reverse1 = name.substring(m, m+1) + reverse1;
			//}
			
			 reverse =  name.substring(r, r+1) + reverse  ;
		}
			System.out.println(reverse);
			//System.out.println(reverse1);
	

	} 
	
}
