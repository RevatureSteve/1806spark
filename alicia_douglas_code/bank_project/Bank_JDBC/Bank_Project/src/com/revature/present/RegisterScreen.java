package com.revature.present;

import java.util.Scanner;

import com.revature.buisnesslogic.BuisnessLogic;
import com.revature.dao.BankAccountDao;
import com.revature.dao.UserDao;
import com.revature.interfaces.Screen;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;

public class RegisterScreen implements Screen {

	@Override
	public Screen start() {

		Scanner scan = new Scanner(System.in);
		System.out.println("*Register New User*");
		System.out.println("Enter your first name:");
		String fname = scan.nextLine();
		System.out.println("Enter your last name:");
		String lname = scan.nextLine();
		System.out.println("Enter your username:");
		String userName = scan.nextLine();
		System.out.println("Enter you password:");
		String password = scan.nextLine();
		System.out.println("Confirm your password:");
		String confPass = scan.nextLine();

		if (BuisnessLogic.checkUsername(userName)) {
			if (BuisnessLogic.passwordCheck(password, confPass)) {
				Users user = new Users(userName, password, fname, lname);
				UserDao userDao = new UserDao();
				userDao.create(user);
				user = userDao.getUserByUserName(userName);
				Users.setCurrentUser(user);
				BankAccount account = new BankAccount(0.0, Users.getCurrentUser().getUserId());
				BankAccountDao bankDao = new BankAccountDao();
				bankDao.create(account);
				account = bankDao.getById(user.getUserId());
				BankAccount.setCurrentAccount(account);
				return new MainMenuScreen().start();
			}
			System.out.println("Passwords do not match");
			return this.start();

		}

		System.out.println("Username is already taken");
		return this.start();
	}

}
