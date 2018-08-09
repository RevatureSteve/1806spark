package com.cpo.dao;

import java.util.List;

import com.cpo.beans.Account;

public interface AccountDao {
	
	int createAccount(Account account);
	
	List<Account> getAccounts(int userId);
	
	int updateAccount(Account account);

}
