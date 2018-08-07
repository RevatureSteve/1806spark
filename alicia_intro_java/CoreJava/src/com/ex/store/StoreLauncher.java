package com.ex.store;

public class StoreLauncher {

	public static void main(String[] args) {
		Screen currentScreen = new MainMenuScreen();
		while(true) {
			currentScreen = currentScreen.start();
		}
	}
	
}
