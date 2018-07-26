package com.ex.petstore;

public class StoreLauncher {

	public static void main(String[] args) {
		Screen currentScreen = new MainScreen();
		while(true) {
			currentScreen = currentScreen .start();
		}
		
		
	}
}
