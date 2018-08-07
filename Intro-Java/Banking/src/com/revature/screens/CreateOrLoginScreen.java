package com.revature.screens;

import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;

public class CreateOrLoginScreen implements Screen {

	@Override
	public Screen start() {
		
		
		//check for username that already exists
		int create = IOHandler.getCreateOrLogin();
		if(create == 0) {
			System.out.println("Creating new user!");
			return new CreateUserScreen();
		}
		return new LoginScreen();
	}
}
