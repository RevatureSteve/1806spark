package com.revature.buisnesslogic;

import java.util.List;

import com.revature.dao.BankAccountDao;
import com.revature.dao.UserDao;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class BuisnessLogic {
	
	public static boolean userExists(String username, String password) {
		
		UserDao users = new UserDao();
		List<Object> userList = users.read();
		
		for (Object obj : userList) {
			Users user = (Users) obj;

			if (username.equals(user.getUserName()) && password.equals(user.getPassword())) {
				Users.setCurrentUser(user);
				return true;
			}
		}
		return false;
	}
	
	public static void findAndSetUserAccount(int userId) {
		BankAccountDao accountDao = new BankAccountDao();
		BankAccount userAccount = accountDao.getById(userId);
		BankAccount.setCurrentAccount(userAccount);
	}

}
