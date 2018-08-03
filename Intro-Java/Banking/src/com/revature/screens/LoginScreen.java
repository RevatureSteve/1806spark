package com.revature.screens;

import com.revature.information.LoggedUser;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;

public class LoginScreen implements Screen {

	
	public LoginScreen() {
		
	}

	@Override
	public Screen start() {
		IOHandler.getLogin();
		IOHandler.getPassword();
		
		if(LoggedUser.getUsername().equals("Marcin")&&LoggedUser.getPassword().equals("Salamon")) {
			return new MainMenuScreen();
		}
		System.out.println("Wrong login or password");
		return this;
	}

}
