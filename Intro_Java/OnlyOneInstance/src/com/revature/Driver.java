package com.revature;

import com.revature.pogo.Hercules;

public class Driver {
	
	/*
	 * Singleton is a type of Design Pattern
	 * 		Goal is to restrict the instantiation to only 1
	 * Design pattern:  common solution to a problem
	 */

	public static void main(String[] args) {
		//4. Instantiate hercules and print the name
		Hercules h = Hercules.getHercules();//the only way to get the only instance of Hercules
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.isAlive());
		
		
//		new Hercules(); cannot do because the constructor Hercules() 
//						is private and not accessible outside of the Hercules Class
		

	}

}
