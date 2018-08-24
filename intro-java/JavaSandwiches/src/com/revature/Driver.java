package com.revature;

import com.revature.pojo.Club;

// shortcut key for imports: ctrl + shift + o

public class Driver {
	/*
	 * constructors: all classes have a constructor, they are not inherited
	 */
	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");
		
//		Sandwich s = new Sandwich(); cannot instantiate a Sandwich since it is abstract
		Club c = new Club();
		try {
			c.setSlicesOfBread(-10);
		} catch (NoNegativeArgumentException e) {
			e.printStackTrace();
		}
		System.out.println(c.getSlicesOfBread());
	}
}
