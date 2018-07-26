package com.project;

public class BankLauncher {
	public static void main(String[] args) {
		HomeScreen currentScreen = new MainMenu();
		while(true) {
			currentScreen = currentScreen.Start();
		}
	}

}
