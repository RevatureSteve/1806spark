package com.ex.store;

import java.util.Scanner;

public class ViewAvailablepetsScreen implements Screen{
	// Scanner is used to take in user input
		private Scanner scan = new Scanner(System.in);

		@Override
		public Screen start() {
			// this list of pets would like be pulled from a database not be hard coded
			System.out.println("please choose from the following options: ");
			System.out.println("1 to adopt one of the  pets");
			System.out.println("2 to play with pets ");
			System.out.println("3 to go back to main menu");
			String input = scan.nextLine();

			switch (input) {
			case "1":
				System.out.println("feature not yet implemented");
			case "2":
			     System.out.println("feature not yet implemented");
			    break;
			case "3":
				return new MainMenuScreen();

			}

			return this;
		}

}
