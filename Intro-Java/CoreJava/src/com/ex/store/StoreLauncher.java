package com.ex.store; // Package name

public class StoreLauncher { 
	public static void main(String[]args) { 
		Screen currentScreen = new MainMenuScreen();// making the new main menu screen
		while(true) { // since it is (true) it will keep looping through the function
			currentScreen = currentScreen.start(); // current screen will start
		}
	}

}
