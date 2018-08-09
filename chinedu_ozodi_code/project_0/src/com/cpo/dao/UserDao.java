package com.cpo.dao;

import com.cpo.beans.User;

public interface UserDao {
	
	int createUser(User user);
	
	User getUser(String username, String password);
	

}
