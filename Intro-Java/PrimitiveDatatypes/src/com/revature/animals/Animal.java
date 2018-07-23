package com.revature.animals;

public class Animal {
<<<<<<< HEAD
	public String altPairs(String str) {
		  String temp = "";
		  for(int i = 0; i < str.length(); i++){
		    temp = temp + str.substring(i, i+1);
		    if(i%2 == 1){
		      i=i+2;
		    }
		  }
		  return temp;
		}
		
=======

	public String name;
	
	public void eat() {
		System.out.println("Animal eats");
	}
	
>>>>>>> 1d2362eb26499c820219011f2c853fc0e02e8dc4
}
