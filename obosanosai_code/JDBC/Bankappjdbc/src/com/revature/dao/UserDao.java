package com.revature.dao;

import java.util.List;

import com.revature.pojo.User;

public interface UserDao {
	
	//	CREATE: insert
	public int createUser(User usr);
	
	public void createUserProc(User usr);
	
	//	READ: select
	public List<User> readUser();
	
	public User getUserById(int id);
	
	//	UPDATE: update
	public int updateUser(User usr);
	
	//	DELETE: delete not yet implemented
	
}
