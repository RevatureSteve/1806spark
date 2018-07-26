package com.revature;

<<<<<<< HEAD
import com.revature.abstracts.Sandwich;
import com.revature.pojo.Club;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches!");
		
		// CONSTRUCTORS 
		
//		Sandwich s = new Sandwich(); //cannot instantiate a sandwich since it is an abstract.

		Club c = new Club();
		// c.slicesOfBread = 10; // cannot do this because it is trying to pull from a private.
		int userInput = 100; 
		
		Club d = new Club();
		//if(userInput >= 0) {
			c.setSlicesOfBread(userInput);
		//}
		System.out.println(c.getSlicesOfBread());
=======
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
	
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	}

}
