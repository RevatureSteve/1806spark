package com.console.drake;

import java.util.Scanner;

public class MainMenuScreen implements Screen {
	
	private Scanner scan = new Scanner(System.in);
	
	public Screen start() {
		
		System.out.println("Hello main menu!");
		String input = scan.nextLine();
		// see if return can break out of "infinite" while loop
		while (true) {
			if (input == "w") {
				return new WelcomeScreen();
			} else if (input == "e") {
				return new ExitScreen();
			}
		}
		
	}

}
