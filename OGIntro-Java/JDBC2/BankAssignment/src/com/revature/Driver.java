package com.revature;

public class Driver {
	
	public static void main(String[] args) {
		Screen currentScreen = new SignIn();
		System.out.println("Welcome to the Cookie Bank!");
		while(true) {
			currentScreen = currentScreen.start();
		}
	}

}
