package com.ex.store;

import java.util.Scanner;

<<<<<<< HEAD
import com.ex.classes.Dog;
import com.ex.classes.Fish;

public class ViewAvailablePetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private Dog d = new Dog("Fluffy", 3, true, "Golden");
	private Fish f = new Fish("Blub", 1, true, 1);

	public ViewAvailablePetsScreen() {
		
	}


	@Override
	public Screen start() {
		System.out.println(d.toString());
		System.out.println(f.toString());
		System.out.println("Please choose from the following options");
		System.out.println("1 to interact with pets");
		System.out.println("2 to view pets");
=======
public class ViewAvailablePetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// this list of pets would like be pulled from a database not be hard coded
		System.out.println("Here are the available pets, sparky the dog, pebbles the fish");
		System.out.println("Please choose from the following options:");
		System.out.println("1 to adopt one of the pets");
		System.out.println("2 to play with pets");
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
<<<<<<< HEAD
			return new InteractWithPetsScreen();
		case "2":
			return new ViewAvailablePetsScreen();
		case "3":
			return new MainMenuScreen();
		}
		return this;
	
	}

=======
			System.out.println("feature not yet implemented");
			break;
		case "2":
			System.out.println("feature not yet implemented");
			break;
		case "3":
			return new MainMenuScreen();
		}

		return this;
	}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
