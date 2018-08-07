package com.dimma.dao;

import com.dimma.user.User;

public interface DaoInterface {


	public User loginUser(String username, String password);
	public User validateUser(String username, String password);
	public masterValidate(User user);
	
}
