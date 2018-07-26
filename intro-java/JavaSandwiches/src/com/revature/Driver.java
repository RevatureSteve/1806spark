package com.revature;

import com.revature.pojo.Club;

import come.revature.exceptions.NoNegativeArgumentException; 




public class Driver {
	/*
	 * Constructor: all classes have a constructor, they are not inherited
	 */

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");

//		Sandwich s = new Sandwich(); cannot instantiate a Sandwich because it's an abstract class
		Club c = new Club();
     try{
    	 c.setSlicesOfBread(-100);
     } catch (NoNegativeArgumentException e) {
    	 e.printStackTrace();
    	 
     }
		
		System.out.println(c.getSlicesOfBread());
	}

}
