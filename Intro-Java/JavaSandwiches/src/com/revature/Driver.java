package com.revature;

import com.revature.pojo.Club;




public class Driver {

	/*
	 *  Constructors: all classes have a constructor, they are not inherited
	 *  	
	 */
	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");
		
//		Sandwich s = new Sandwich(); cannot instantiate a Sandwich since it is abstract
		Club c = new Club();
//		c.slicesOfBread = -100;
		int userInput = -100;
		if(userInput >= 0) {
			c.setSlicesOfBread(userInput);
		}
		
		System.out.println(c.getSlicesOfBread());
	
	}

}
