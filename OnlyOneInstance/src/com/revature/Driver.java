package com.revature;

import com.revature.pojo.Hercules;

public class Driver {
	/*
	 * Singleton is a type of Design Pattern
	 * 
	 * The goal is to restrict the instantiation to only 1
	 * 
	 * 
	 * Design Pattern is a common solution to a problem
	 * 
	 * 
	 */
	
	
	public static void main(String[] args) {
		System.out.println("testy test test");
//	4. instantiate Hercules and get print the name
		
		Hercules h1 = Hercules.getHercules();
		Hercules h2 = Hercules.getHercules();
		Hercules h3 = Hercules.getHercules();
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		
		h3.setAge(500);
		
		System.out.println();
		Hercules h = Hercules.getHercules();    //this is now the only way to get the only instance of Hercules
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.isAlive());
		
//	new Hercules(); cannot do because of the constructor Hercules() is private and 
		//not accessible outside of the Hercules class
		
		
	
	
	}

}
