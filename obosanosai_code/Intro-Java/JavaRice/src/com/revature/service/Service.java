package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.reavture.daoimpl.AccountDAOimpl;
import com.reavture.daoimpl.UserDAOimpl;
import com.revature.beans.*;

public class Service {

	UserDAOimpl udao = new UserDAOimpl();
	AccountDAOimpl adao = new AccountDAOimpl();
	
	
	
	//checks if the user who just logged in is a user or an admin
//	public boolean isUser(String username)
//	{
//		try
//		{
//			if (udao.getStatus(username) == 0)
//			{
//				return true;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return false;
//		
//	}

	//create user from user input information
	public void createUser(String fname, String lname, String username, String password)
	{
		try {
			udao.addUser(fname, lname, username, password);
		} catch (SQLException e) {
			System.out.println("Couldn't create user at Service:  " + e.getMessage());
		}
	}
	
	
	//auto create Account with 0.0 default balance and auto generated_ID
	public void createAccount(String username, double initAmount)
	{
		try
		{
			adao.addAccount(username, initAmount);
		}catch (SQLException e) {
			System.out.println("Couldn't create account at Service:  " + e.getMessage());
		}
		
	}
	
	
	//get list of accounts from user
	public List<Account> getAccounts(String username)
	{
		try
		{
			return adao.getAccounts(username);
		}catch (SQLException e) {
			System.out.println("Couldn't create account at Service:  " + e.getMessage());
		}
		
		
		return null;
	}

	
		//obtains user_id from username 
	public int getuserId(String username)
	{
		
		try {
			return udao.getUsersId(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	//obtains account balance from username
	public double getAccountBalance(String username, int usersId)
	{
		try{
			return adao.getBal(username, usersId);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0.0;
	}
	
	
	//updates the account balance 
	public void updateAccountBalance(String username, double amount, int usersId)
	{
		try{
			adao.updateBal(username, amount, usersId);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	
	//withdraw specified amount from account
	public boolean withdraw(double wAmount, String username, int usersId)
	{
		double balance = getAccountBalance(username, usersId);
		if (wAmount > 0.0)
		{
			if(wAmount > balance)
			{
				return false;
			}
			else 
			{
				updateAccountBalance(username, (balance - wAmount), usersId);
				return true;
			}
		}
		
		return false;
	
	}
	
	
	//deposit specified amount into account
	public boolean deposit(double dAmount, String username, int usersId)
	{	
		double balance = getAccountBalance(username, usersId);
		if (dAmount > 0.0) //if the deposit amount is a valid one
		{
			updateAccountBalance(username, (balance + dAmount), usersId);
			return true;
		}
		
		return false;
	}
	
	public boolean closeAccount(String username, int usersId)
	{
		try{
			adao.deleteAccount(username, usersId);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public List<User> getUsers()
	{
		
		try{
			return udao.getUsers();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}


	public boolean isUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
