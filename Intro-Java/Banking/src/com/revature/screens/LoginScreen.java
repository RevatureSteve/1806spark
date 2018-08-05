package com.revature.screens;

import com.revature.dao.UserDao;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.singletons.LoggedUser;

public class LoginScreen implements Screen {

	
	public LoginScreen() {
		
	}

	@Override
	public Screen start() {
		IOHandler.getUser();
		UserDao ud = new UserDao();
		
		if(ud.validateUser(LoggedUser.getUser().getUsername(), LoggedUser.getUser().getPassword())) {
			return new MainMenuScreen();
		}
		System.out.println("Wrong login or password");
		return this;
	}
}
