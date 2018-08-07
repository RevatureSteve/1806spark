package com.revature.dao;

import java.util.List;

import com.revature.pojo.Users;

/*
 * This is the DAO where I will be doing all my sql 
 */
public interface MainDao {

	//CREATE
	public int create(Object obj);
	
	
	//READ
	/*
	 * This is where I use the getUserByUserName to get the username and password from sql using the SELECT statement
	 * 		I seperated the implementation for this and placed it within the UserDaoImpl 
	 * 
	 * 
	 */
	public List<Object> read();
	public Users getUserByUserName(String userName);
	//public Users getUserByUserId(int userId);
	
	
	//UPDATE
	public int update(Object obj);
	
	//DELETE
	
}
