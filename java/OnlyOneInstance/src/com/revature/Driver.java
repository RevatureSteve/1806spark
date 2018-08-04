package com.revature;

import com.revature.pojo.Hercules;

public class Driver {
	/*
	 * singleton is a type of design pattern
	 * 		goal is to restrict the instantiation to only one
	 * 
	 * design pattern: common solution to a problem
	 */
	
	
	public static void main(String [] args) {
		System.out.println("Test");
		
		Hercules h = Hercules.getHercules(); //the only way to get an instance/object now of Hercules now
		System.out.println(h.getName());
		System.out.println(h.getAge());
		System.out.println(h.isAlive());
	
		
//		new Hercules();  // you can no longer used the new keyword bc Hercules
		//  is private and not accessible outside of the class Hercules
	}
	


}
