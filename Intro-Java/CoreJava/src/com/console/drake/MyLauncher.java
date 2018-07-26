package com.console.drake;

public class MyLauncher {
	
	public static boolean exit = false;
	
	int j = 3;
	
	public static void main(String[] args) {
		
		// covariance; different reference type [on the left of assignment] than object type
		Screen currentScreen = new WelcomeScreen();
		while (exit == false) {
			currentScreen = currentScreen.start();
		}
		
	}
	
//	might create Launcher object, or an instantiation of a class, elsewhere in package to use this:
	
//	public boolean setExit(boolean bye) {
//		return exit = bye;
//	}

}
