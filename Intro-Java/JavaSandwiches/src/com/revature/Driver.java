package com.revature;

import com.revature.pojo.Club;

<<<<<<< HEAD
// shortcut key for imports: ctrl + shift + o

public class Driver {
	
	/*
	 * 	Constructors: all classes have a constructor, they are not inherited
	 */

=======



public class Driver {

	/*
	 *  Constructors: all classes have a constructor, they are not inherited
	 *  	
	 */
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");
		
//		Sandwich s = new Sandwich(); cannot instantiate a Sandwich since it is abstract
		Club c = new Club();
<<<<<<< HEAD
		int userInpt = -100;
		if(userInpt >= 0) {
			c.setSlicesOfBread(userInpt);
		}
		System.out.println(c.getSlicesOfBread());
	
	}
=======
//		c.slicesOfBread = -100;
		int userInput = -100;
		if(userInput >= 0) {
			c.setSlicesOfBread(userInput);
		}
		
		System.out.println(c.getSlicesOfBread());
	
	}

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
