package com.revature.bank.Dao;

import com.revature.bank.pojo.UsersPojo;

/**
 * This DAO is used for persistence of user name and password information.
 * @author tyler
 *
 */
public interface UserPassDao {
	
//CREATE
	public void createUsername();
	public void createPassword();



//READ

	public boolean verifyUsername(UsersPojo user);
	public void verifyPassword();


//UPDATE

	



//DELETE
	
}
