package com.revature;

import com.revature.pojo.Club;

// Shorcut key for imports: ctrl + shft + o


public class Driver {

	/*
	 * Constructors: all classes have a constructor, they are not inherited
	 */
	public static void main(String[] args) {
		System.out.println("Going to create a sandwich");
		
//		Sandwich s = new Sandwich(); //Cannot instantiate a Sandwich since it is abstract
		Club c = new Club();
		
	}

}
