package com.revature.dao;

import java.util.List;

import com.revature.pojos.User;

public interface UserDao {
	public List<User> getAllUsers();

	public User getUserBy(int id);

	public int insertUser(User user);
}
