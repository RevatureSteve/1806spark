package com.revature;

import com.revature.presentation.Screen;
import com.revature.presentation.WelcomeScreen;

public class Driver {
	
	public static void main(String[] args) {
		Screen currentScreen = new WelcomeScreen();
		while(true) {
			currentScreen = currentScreen.start();
		}
		
	}

}

