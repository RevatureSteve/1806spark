package com.revature;

<<<<<<< HEAD
import com.revature.abstracts.Sandwich;
import com.revature.pojo.Club;

//shortcut key for imports ctrl+shift+o;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Going to create sandwiches");

//		Sandwich s = new Sandwich(); cannot instantiate abstract classes
		Sandwich c = new Club();
		c.startPrep();
		int size = c.takeBite();
		System.out.println(size);
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
