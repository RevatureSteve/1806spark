package com.revature.dao;

import java.util.List;

import com.revature.pojo.TranstarUsers;

public interface TranstarUserDao {

	public List<TranstarUsers> readUsers();
	
	public TranstarUsers getUser(String email);
}
