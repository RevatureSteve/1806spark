package com.revature.dao;

import com.revature.pogo.Account;
import com.revature.pogo.Users;

public interface BankDao {

	// CREATE

	// READ
	public Users confirmUser(String username, String password);

	public Account getBalance(int userId);

	// UPDATE
	public void setDepositAmount(int usersId, double depoAmount);

	public void setWithdrawAmount(int usersId, double withAmount);

	// DELETE

}
