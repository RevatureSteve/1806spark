package com.revature;
import com.revature.interfaces.Screen;
import com.revature.screens.LoginScreen;

public class Driver {
	public static void main(String[] args) {
		Screen current = new LoginScreen();
		while(true) {
			current = current.start();
		}
	}
}
