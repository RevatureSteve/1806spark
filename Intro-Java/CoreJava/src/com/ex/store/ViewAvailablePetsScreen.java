package com.ex.store;

import java.util.Scanner;

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
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();

		switch (input) {
		case "1":
			return new InteractWithPetsScreen();
		case "2":
			return new ViewAvailablePetsScreen();
		case "3":
			return new MainMenuScreen();
		}
		return this;
	
	}

}
