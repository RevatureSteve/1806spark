package com.revature;

import com.revature.pojo.Hercules;

public class Driver {

	/*
	 * 
	 * 		Singleton is a type of Design Pattern
	 * 
	 * 
	 * 		Design pattern: common solution to a problem 
	 * 
	 * 
	 * 		Goal is to restrict the instantiation to only 1
	 * 
	 * 		
	 * 
	 * 		
	 */
	public static void main(String[] args) {
		
		//Instantiate Hercules and print the name
		Hercules h = Hercules.getHercules(); //The only way to get an instance of this object now
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.isAlive());
//		new Hercules();  Cannot do that because the constructor Hercules is private and not accessible outside 
//		new Hercules();  of the Hercules class
//		new Hercules(); 
//		new Hercules(); 
//		new Hercules(); 
		
		
		
		
		
		
		

	}

}
