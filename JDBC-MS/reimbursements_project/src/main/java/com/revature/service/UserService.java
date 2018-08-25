package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.dao.UsersDaoImpl;
import com.revature.domain.User;
import com.revature.exceptions.DatabaseRetrievalFailure;

public class UserService {

	static UsersDao uDao = new UsersDaoImpl();

	public static User updateUserInfo(User user) {
		int rowsAffected = uDao.updateUserInfo(user.getuId(), user.getEmail(), user.getPassword(), user.getFname(),
				user.getLname());
		if(rowsAffected == 0) {
			System.out.println("failed");
		}
		try {
			return uDao.getUserByUsername(user.getEmail());
		} catch (DatabaseRetrievalFailure e) {
			e.printStackTrace();
		}
		return null;
	}

	public static List<User> getEmployees() {
		List<User> users = uDao.getUsers();
		List<User> employees = new ArrayList<User>();
		for(User user: users) {
			if(user.getPositionId() == 1) {
				user.setPassword("");
				employees.add(user);
			}
		}
		
		return employees;
	}

}
