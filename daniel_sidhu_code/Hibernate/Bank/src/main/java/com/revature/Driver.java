package com.revature;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.domain.BankUser;

public class Driver {
	public static void main(String[] args) {
		BankDao bk = new BankDaoImpl();//create the dao
		BankUser bu = new BankUser();//create the user
		bu = bk.getBankUser(5);//get the user with a Bank Id of 5
		System.out.println("Bank User is: " + bu);
	}
}
