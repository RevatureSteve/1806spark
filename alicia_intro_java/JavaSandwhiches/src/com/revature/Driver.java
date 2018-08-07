package com.revature;

import com.revature.pojo.Club;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Going to create sandwhiches");
		
//		Sandwhich s = new Sandwhich(); cannot instantiate a Sandwhich since it it abstract
		
		Club c = new Club();
		
		int userInput = -100;
		if (userInput >= 0) {
			c.setSlicesOfBread(userInput);
		}

	}

}
