package com.revature;

import com.revature.Reptile;

public class Launcher {

	public static void main(String[] args) {
		System.out.println("Printing Reptiles...");

		// public static void takeReptile(Reptile reptile) {
		System.out.println("Reptile");
		// }

		BallPython b = new BallPython(); // creating a new BallPython object
		System.out.println(b);// Prints out BallPython object
		//unreadable unless I override toString
		{
			try {
				b.setName(""); // if someone doesn't enter a name
			} catch (NoNameException e) { // use this exception to catch that
				e.printStackTrace(); // print the message that I set for that
			}
			try { 
				b.setHasScales(false); // if someone sets HasScales to false
			} catch (NoScalesException e) { // then use this exception to catch that
				e.printStackTrace(); // then print the message that I set 
			}
		}

	}
}
