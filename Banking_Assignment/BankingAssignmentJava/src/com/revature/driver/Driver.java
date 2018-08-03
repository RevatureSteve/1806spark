package com.revature.driver;

import java.util.Scanner;

import com.revature.presentation.PresentationLogic;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scanny = new Scanner(System.in);
		while(true)	{
			PresentationLogic.presentScreen();
			int userSelection = scanny.nextInt();
			switch (userSelection) {
			
			case 1:
					PresentationLogic.loginScreen();
				break;
			case 2:
					PresentationLogic.creatingNewUser();
				break;
			case 3:
					System.out.println("\nExiting...\nThank you for using Humphrey Central Bank!");
				System.exit(1);
				break;
			default: 
					System.out.print("Enter a number 1 - 3");
			
			}
		}

	}

}
