package com.revature;

import com.revature.pojo.Hercules;

public class Driver {
<<<<<<< HEAD
	
	/*
	 * 		Singleton is a type of Design Pattern
	 *			Goal is to restrict the instantiation to only 1 
	 * 		Design pattern: common solution to a problem
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("test"); 
		
		//4. instantiate hercules and print the name
		Hercules h1 = Hercules.getHercules();
		Hercules h2 = Hercules.getHercules();
		Hercules h3 = Hercules.getHercules();
=======

	/*
	 * 		Singleton is a type of Design Pattern
	 * 			Goal is to restrict the instantiation to only 1
	 * 		Design pattern: common solution to a problem
	 * 
	 * 		
	 * 
	 */
	public static void main(String[] args) {
		//4. instantiate hercules and print the name
		Hercules h1 = Hercules.getHercules(); // the only way to get the only instance of Hercules
		Hercules h2 = Hercules.getHercules(); // the only way to get the only instance of Hercules
		Hercules h3 = Hercules.getHercules(); // the only way to get the only instance of Hercules
		
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		
		h3.setAge(500);
		
<<<<<<< HEAD
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);

//		new Hercules();  // Cannot do because the constructor Hercules()
						 // is private and not accessible outside of the Hercules class
	} 
=======
		
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
//		new Hercules(); cannot do because the constructor Hercules() 
//		new Hercules();	is private and not accessible outside of the Hercules class
//		new Hercules();
//		new Hercules();
//		new Hercules();
	}

>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
}
