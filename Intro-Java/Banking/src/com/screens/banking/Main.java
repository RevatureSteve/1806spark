package com.screens.banking;

import com.interfaces.banking.Screen;

public class Main {

	public static void main(String[] args) {
		Screen currentScreen = new LoginScreen();

		while(true) {
			currentScreen = currentScreen.start();
		}
	}

}
