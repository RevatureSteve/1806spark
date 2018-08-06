package com.revature.screens;

import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.iohandler.ValidationTool;
import com.revature.singletons.LoggedUser;

public class LoginScreen implements Screen {

	@Override
	public Screen start() {
		int create = IOHandler.getUser();
		ValidationTool vt = new ValidationTool();
		if(create == 0) {
			System.out.println("Creating new user!");
			return new CreateUserScreen();
		}
		
		if(vt.validateUser(LoggedUser.getUser().getUsername(), LoggedUser.getUser().getPassword())) {
			return new MainMenuScreen();
		}
		System.out.println("Wrong login or password");
		return this;
	}
}
