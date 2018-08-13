package com.revature.dao;


import java.util.ArrayList;

import com.revature.domain.User;
import com.revature.exceptions.DatabaseRetrievalFailure;

public interface UsersDao {
	public ArrayList<User> getUsers();
	
	public User getUserByUsername(String username) throws DatabaseRetrievalFailure;
}
