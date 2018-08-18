package com.cpo.doa;

import com.cpo.model.User;

public interface UserDao {
	
	//CREATE 
	int createUser(User user);
	
	//READ
	User getUserByEmail(String email);
	

}
