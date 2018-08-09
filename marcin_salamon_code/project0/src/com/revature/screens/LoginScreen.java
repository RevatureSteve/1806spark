package com.revature.screens;

import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.iohandler.Service;
import com.revature.singletons.LoggedUser;

public class LoginScreen implements Screen {

	@Override
	public Screen start() {
		IOHandler.getUser();
		Service vt = new Service();
		
		if(vt.validateUser(LoggedUser.getUser().getUsername(), LoggedUser.getUser().getPassword())) {
			return new MainMenuScreen();
		}
		System.out.println("Wrong login or password");
		return this;
	}
}
