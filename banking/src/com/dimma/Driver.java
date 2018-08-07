package com.dimma;
import com.dimma.presentation.*;


public class Driver {

	public static void main(String[] args) {
		
		Screen currentScreen = new LoginMenu();
		
		while(true) {
			currentScreen = currentScreen.start();
		}
	

	

}
}