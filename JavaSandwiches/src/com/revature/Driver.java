package com.revature;

import com.revature.pogo.Club;

public class Driver {

	public static void main(String[] args) {
		System.out.println("I am going to create sandwiches");
		
		/*Sandwich s = new Sandwich(); cannot instatiate a Sandwich since it is abstract*/
		Club c = new Club(); 
		c.setSlicesOfBread(100);//forced to handle w/ try/catch 
		System.out.println(c.getSlicesOfBread());
	}

}
