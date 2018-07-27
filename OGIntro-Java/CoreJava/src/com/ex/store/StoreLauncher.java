<<<<<<< HEAD
package com.ex.store; // Package name

public class StoreLauncher { 
	public static void main(String[]args) { 
		Screen currentScreen = new MainMenuScreen();// making the new main menu screen
		while(true) { // since it is (true) it will keep looping through the function
			currentScreen = currentScreen.start(); // current screen will start
		}
	}

=======
package com.ex.store;

public class StoreLauncher {
	
	
	
	public static void main(String[] args) {
		Screen currentScreen = new MainMenuScreen();
		while(true) {
			currentScreen = currentScreen.start();
		}
	}
>>>>>>> d475e543ae45678c0e0ef13aa404b494ea00a41e
}
