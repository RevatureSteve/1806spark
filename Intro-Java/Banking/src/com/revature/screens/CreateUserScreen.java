package com.revature.screens;

import com.revature.dao.UserDao;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.pojos.User;

public class CreateUserScreen implements Screen {

	@Override
	public Screen start() {
		User user = IOHandler.displayCreateUserScreen();
		UserDao udao = new UserDao();
		int rowsAffected = udao.insertUser(user);
		if(rowsAffected == 0) {
			System.out.println("New user failed");
		}
		return new LoginScreen();
	}
}
