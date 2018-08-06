package com.revature;

import com.revature.pojo.Hercules;

public class Driver {
	
	/*
	 * 		Singleton is a type of Design Pattern
	 *			Goal is to restrict the instantiation to only 1 
	 * 		Design pattern: common solution to a problem
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("test"); 
		
		//4. instantiate hercules and print the name
		Hercules h1 = Hercules.getHercules();
		Hercules h2 = Hercules.getHercules();
		Hercules h3 = Hercules.getHercules();
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		
		h3.setAge(500);
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);

//		new Hercules();  // Cannot do because the constructor Hercules()
						 // is private and not accessible outside of the Hercules class
	} 
}
