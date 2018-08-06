package com.project.logic;

import java.util.List;

import com.project.dao.AccountDao;
import com.project.dao.UserDao;
import com.project.pojo.BankBal;
import com.project.pojo.BankUsers;

public class Logic {

	
	
	public static boolean userInDb(String username, String password) {
		UserDao users = new UserDao();
		List<Object> userList = users.read();
		for(Object obj : userList) {
			BankUsers user = (BankUsers) obj;
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				BankUsers.setCurrentUser(user);
				return true;
			}
		}
		
		
		return false;
	}
	
	public static String getFirstName(String username, String password) {
		String validUser = null;
		
		UserDao users = new UserDao();
		List<Object> userList = users.read();
		for(Object obj : userList) {
			BankUsers user = (BankUsers) obj;
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
			validUser = user.getfName();
			}
			
		}
		return validUser;
	}
	
	public static BankUsers getUserId(String username, String password) {
		
		BankUsers userId = null;
		
		UserDao users = new UserDao();
		List<Object> userList = users.read();
		for(Object obj : userList) {
			
			BankUsers user = (BankUsers) obj;
			if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
			userId = user.getCurrentUser();
			}
			
		}
		return userId;
	}
	
}
