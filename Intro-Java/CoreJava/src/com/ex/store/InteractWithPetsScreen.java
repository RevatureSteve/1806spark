package com.ex.store;

import java.util.Scanner;

<<<<<<< HEAD
import com.ex.classes.Dog;
import com.ex.classes.Fish;

public class InteractWithPetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);
	private Dog d = new Dog("Fluffy", 3, true, "Golden");
	private Fish f = new Fish("Blub", 1, true, 1);
	public InteractWithPetsScreen() {
		
	}

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options");
		System.out.println("1 to speak dog");
		System.out.println("2 to speak fish");
=======
public class InteractWithPetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		System.out.println("Please choose from the following options:");
		System.out.println("1 to speak with your pets");
		System.out.println("2 to play with pets");
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
<<<<<<< HEAD
			d.speak();
			break;
		case "2":
			f.speak();
			break;
		case "3":
			return new MainMenuScreen();
		}
		return this;
	
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
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
	}

}
