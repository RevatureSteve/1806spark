package com.ex.store;

import java.util.Scanner;
<<<<<<< HEAD
import com.ex.classes.Launcher;
import com.ex.classes.Pet;

public class ViewAvailablePetsScreen implements Screen {

private Scanner scan = new Scanner(System.in);
	
	@Override
	public Screen start() {
		
		System.out.println("Please choose from the following options:");
		System.out.println("Here are the available pets:");
		
		Pet[] p = new Pet[5];
		for (int i = 0; i < p.length; i++) {
			p[i] = Launcher.randPet();
		}
		for ( Pet petName: p ) {
			System.out.print(petName.getName() + " ");
		}
		System.out.println();
		
=======

public class ViewAvailablePetsScreen implements Screen {
	private Scanner scan = new Scanner(System.in);

	@Override
	public Screen start() {
		// this list of pets would like be pulled from a database not be hard coded
		System.out.println("Here are the available pets, sparky the dog, pebbles the fish");
		System.out.println("Please choose from the following options:");
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		System.out.println("1 to adopt one of the pets");
		System.out.println("2 to play with pets");
		System.out.println("3 to go back to main menu");
		String input = scan.nextLine();
<<<<<<< HEAD
		
=======

>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
		switch (input) {
		case "1":
			System.out.println("feature not yet implemented");
			break;
		case "2":
			System.out.println("feature not yet implemented");
			break;
		case "3":
			return new MainMenuScreen();
		}
<<<<<<< HEAD
		
		return this;
		
	}
	
=======

		return this;
	}
>>>>>>> ec6e1080cc8d22ffe15518fa344d4cd7dc0b1146
}
