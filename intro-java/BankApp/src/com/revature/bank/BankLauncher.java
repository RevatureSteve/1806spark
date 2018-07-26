package com.revature.bank;

public class BankLauncher {
	public static void main(String[] args) {
		Screen currentScreen = new MainMenuScreen();
		System.out.println("Welcome to the bank!");
		while(true) {
			currentScreen = currentScreen.start();
		}
	}
}
