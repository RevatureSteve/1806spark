package com.revature.service;

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

}
