package com.revature;
import com.revature.interfaces.Screen;
import com.revature.screens.CreateOrLoginScreen;

public class Driver {
	public static void main(String[] args) {
		Screen current = new CreateOrLoginScreen();
		while(true) {
			current = current.start();
		}
	}
}
