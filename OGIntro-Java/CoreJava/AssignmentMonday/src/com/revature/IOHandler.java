package com.revature;

import java.util.Scanner;

import com.revature.Launch;

import com.revature.Shark;


public class IOHandler {
	public static int userInput() {
		Scanner scan = new Scanner(System.in); // Prepares to take user input
		System.out.println("Select a Fish from the Menu"); //text menu options
		System.out.println("Press 1 for Shark"); //option 1
		System.out.println("Press 2 for Grouper"); // option 2
		System.out.println("Press 3 for Groupie the Grouper"); //option 3
		int inputSize =10 ;
		
		int menu1 = scan.nextInt(); // takes user input
		switch (menu1) {
		case 1:
			System.out.println("Shark size is " + inputSize); 
			// when you pick shark, this will display the shark size
			break;

		case 2:
			System.out.println("Enjoy your meal");
			break;
			
		case 3:
			System.out.println("Groupie the Grouper");
			break;
		}
		return menu1;
		
	}

}
