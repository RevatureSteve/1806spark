package com.revature;

import com.revature.presentation.MainMenuScreen;

public class Driver {
	
	
	public static void main(String[] args) {
		System.out.println("Welcome! To the banking app!");
		Screen currentScreen = new MainMenuScreen();
		while(true) {			
			currentScreen = currentScreen.start();
		}
	}
}
