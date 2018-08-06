package com.revature;

import com.revature.displays.LoginDisplay;
import com.revature.interfaces.Screen;

public class Driver {

	public static void main(String[] args) {
		Screen curScreen = new LoginDisplay();
		while(true) {
			curScreen = curScreen.start();
		}
	}

}
