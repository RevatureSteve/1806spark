package com.revature.service;

import java.util.ArrayList;

import com.revature.dao.UsersDaoImpl;
import com.revature.domain.User;

public class VerificationService {
	public static boolean verifyUsernameAndPassword(String username, String password) {
		ArrayList<User> users = (ArrayList<User>) new UsersDaoImpl().getUsers();
		
		for(User user : users) {
			if(user.getEmail().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		
		return false;
	}
}