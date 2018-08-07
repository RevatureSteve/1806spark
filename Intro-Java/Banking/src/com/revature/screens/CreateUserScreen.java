package com.revature.screens;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.iohandler.ValidationTool;
import com.revature.pojos.User;

public class CreateUserScreen implements Screen {

	@Override
	public Screen start() {
		User user = IOHandler.displayCreateUserScreen();
		UserDao udao = new UserDao();
		ValidationTool vt = new ValidationTool();
		List<User> listOfUsers = udao.getAllUsers();
		if(!vt.containsNewUser(user, listOfUsers)) {
			int rowsAffected = udao.insertUser(user);
			if(rowsAffected == 0) {
				System.out.println("New user failed");
				return new CreateUserScreen();
			}
		}else {
			IOHandler.usernameExistsStatus();
		}
		
		return new CreateOrLoginScreen();
	}
}
