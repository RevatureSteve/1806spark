package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;
import com.revature.businessLogic.BusinessLogic;
import com.revature.dao.UserDaoImpl;
import com.revature.pojo.Users;

public class LoginScreen implements Screen {

	@Override
	public Screen Start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("the login page");
		System.out.println("enter username");
		String userName = scan.nextLine();
		System.out.println("enter password");
		String password = scan.nextLine();
		
		if(BusinessLogic.userExsists(userName, password)) {
			return new UsersMenuScreen().Start();
		}
		System.out.println("The Login has Failed");
		return this;
	}

}

/*UserDaoImpl x = new UserDaoImpl();
Users y = x.getUserByUserName(userName);
y.getPassword();*/