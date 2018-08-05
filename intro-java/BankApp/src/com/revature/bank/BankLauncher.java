package com.revature.bank;

import com.revature.bank.dao.BankDao;
import com.revature.bank.pojo.User;
import com.revature.bank.presentation.Presentation;

public class BankLauncher {
	public static void main(String[] args) {
		System.out.println("Welcome to the bank! please login");
		BankDao bDao = new BankDao();
		User u = Presentation.login();
		System.out.println(u);
		User db_u = bDao.getFlashCardById(u.getUsername());
		System.out.println(db_u);
	}
}
