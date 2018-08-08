package com.revature.screens;

import java.util.List;

import com.revature.dao.UserDaoImpl;
import com.revature.interfaces.Screen;
import com.revature.iohandler.IOHandler;
import com.revature.iohandler.Service;
import com.revature.pojos.User;

public class CreateUserScreen implements Screen {

	@Override
	public Screen start() {
		User user = IOHandler.displayCreateUserScreen();
		UserDaoImpl udao = new UserDaoImpl();
		Service vt = new Service();
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
