package com.revature;

import com.revature.pojo.Club;



// shortcut key for import is : ctrl + shft + o

public class Driver {
	
	/*
	 * constructors: all classes have a constructor, they are not inherited
	 * */
		public static void main(String [] args) {
			System.out.println("hello this is working, we are going to create sandwishes");
			
//			Sandwish s = new Sandwish();  // cannot instantiate Sandwich since it is abstract
			
			Club c = new Club();
//			c.getSliceOfBread();
			c.setSliceOfBread(-100); 
			System.out.println("slice of bread " + c.getSliceOfBread());
		}
}
