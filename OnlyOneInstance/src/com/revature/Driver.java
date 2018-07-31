package com.revature;

import com.revature.pojo.Hercules;

public class Driver {

	/*
	 * Singleton is a type of Design Pattern
	 * 		goal is to restrict the instantiation to only one 	
	 * 
	 * 	Design pattern: common solution to a problem 
	 */
	public static void main(String[] args) {
		//System.out.println("test");
		
		//4. instantiate hercules and print the name
		Hercules h = Hercules.getHercules();// the only way to get an instance of Hercules
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.isAlive());
		
		//new Hercules(); //cannot use b/c the constructor Hercules() is private and not accessible outside of the Hercules class
		
		
		
	}

}
