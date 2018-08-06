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

	public boolean verifyUsernameAndPassword(UsersPojo user);
	


//UPDATE

	public int bankDeposit(int depositNum, double depositAmount);
	public int bankWithdraw(int depositNum, double depositAmount);



//DELETE
	
}
