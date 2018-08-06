package com.revature;

import com.revature.pojo.Hercules;

/*
 *  Singleton is a type of Design Pattern
 *  	Goal is to restrict the instantiation to only 1
 *  Design pattern: common solution to a problem
 *  
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("Test");
		
		Hercules h = Hercules.getHercules();// the only way to get the only instance of Hercules
		System.out.println(h.getName() + h.getAge() + h.isAlive());
		//new Hercules();// cannot do because the constructor Hercules() is private and not accessible outside of the Hercules class
	}

}
