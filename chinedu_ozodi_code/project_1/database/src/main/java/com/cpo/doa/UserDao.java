package com.cpo.doa;

import java.util.List;

import com.cpo.model.User;

public interface UserDao {
	
	//CREATE 
	int createUser(User user);
	
	//READ
	User getUserByEmail(String email);

	User getUserById(int id);

	List<User> getAllUsers();
	

}
