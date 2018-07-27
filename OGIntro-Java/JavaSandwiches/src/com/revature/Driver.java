package com.revature;

<<<<<<< HEAD
//shortcut key for imports: ctrl(command) + shift + o
import com.revature.abstracts.Sandwich;

=======
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
import com.revature.pojo.Club;




public class Driver {
<<<<<<< HEAD
	
	/*
	 * Constructors: all classes have a constructor, they are not inherited
	 */

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");
	}
//	Sandwich s = new Sandwich(); cannot instantiate a Sandwich since it is abstract
	Club c = new Club();{
		int userInput = -100;
		if(userInput >= 0) {
		c.setSlicesOfBread(userInput);
		}
		System.out.println(c.getSlicesOfBread());

	}
	
	
=======

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

>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
