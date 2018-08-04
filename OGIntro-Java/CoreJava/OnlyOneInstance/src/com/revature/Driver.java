package com.revature;

import com.revature.pojo.Hercules;

public class Driver {
	

	/*
	 * Singleton is a type of Design Pattern
	 * 	Goal is to restrict the instantiation to only 1
	 * Design pattern: common solution to a problem
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("test");
		//4. instantiate hercules and print the name
		Hercules h = Hercules.getHercules(); // this is the only way to get an instance of Hercules now
		
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.isAlive());
		
		//new Hercules(); cannot do because of the constructor HErcules()
		//new Hercules(); is private and not accessible outside of the Hercules class
		//new Hercules();
	}
	
	
}
