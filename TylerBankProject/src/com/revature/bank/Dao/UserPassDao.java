package com.revature.bank.Dao;

import com.revature.bank.pojo.Bank_AccountPojo;
import com.revature.bank.pojo.UsersPojo;

/**
 * This DAO is used for persistence of user name and password information.
 * @author tyler
 *
 */
public interface UserPassDao {
	
//CREATE




//READ

	public boolean verifyUsernameAndPassword(UsersPojo user);
	public Bank_AccountPojo viewBalance(int uid);


//UPDATE

	public int bankDeposit(int depositNum, double depositAmount);
	public int bankWithdraw(int depositNum, double depositAmount);



//DELETE
	
}
