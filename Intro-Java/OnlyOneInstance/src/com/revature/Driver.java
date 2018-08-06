package com.revature;

import com.revature.pojo.Hercules;

public class Driver {
	
	/*
	 * 		Singleton is a type of Design Pattern
	 * 			Goal is to restrict the instantiation to only 1
	 * 		Design Pattern: common solution to a problem
	 */
	public static void main(String[] args) {
		System.out.println("test");
		//4. instantiate hercules and print the name
		Hercules h = Hercules.getHercules(); //	the only way to get the only instance of Hercules
		Hercules h1 = Hercules.getHercules();
		Hercules h2 = Hercules.getHercules();
		
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.isAlive());
		System.out.println(h);
		
		System.out.println(h1.getName());
		System.out.println(h1.getAge());
		System.out.println(h1.isAlive());
		System.out.println(h1);
		
		System.out.println(h2.getName());
		System.out.println(h2.getAge());
		System.out.println(h2.isAlive());
		System.out.println(h2);
		
//		new Hercules(); cannot do because the constructor Hercules()
//		new Hercules(); is private and not accessible outside of the Hercules class
	}

}
