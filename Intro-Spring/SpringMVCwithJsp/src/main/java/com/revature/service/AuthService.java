package com.revature.service;

import org.springframework.stereotype.Component;

import com.revature.models.User;

@Component
public class AuthService {
	
	
	public User auth(User user) {

		User authUser = null;

		if ("john".equals(user.getUsername()) && "123".equals(user.getPassword())) {
			authUser = user;
		} else {
			authUser = null;
		}

		return authUser;

	}

}
