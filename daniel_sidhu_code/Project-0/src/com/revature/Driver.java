package com.revature;
/**
 * This is project 0
 */
import com.revature.presentation.MainMenuScreen;

public class Driver {

	public static void main(String[] args) {
		
		Screen currentScreen = new MainMenuScreen();
		
		while(true) {
			currentScreen = currentScreen.Start();
		}
		
	}

}
