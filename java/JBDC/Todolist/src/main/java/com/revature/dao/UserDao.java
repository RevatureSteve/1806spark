/**
 * 
 */
package com.revature.dao;

import com.revature.domain.User;

/**
 * @author sethc
 *
 */
public interface UserDao {
	//remember that DAO: data access object( only crud methods!)
	
	//CREATE
	
	//READ
	public User getUserByUsernamw(String username);
	
	//UPDATE
	
	//DELETE

}
