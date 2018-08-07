package com.dimma.presentation;

import java.util.Scanner;

import com.dimma.logic.Logic;
import com.dimma.user.User;

public class LoginMenu implements Screen{

	@Override
	public Screen start() {
		
		System.out.println("");
			Scanner scan = new Scanner(System.in);
			System.out.println("---Please Login---");
			System.out.println("----Enter Username-----");
			String username = scan.nextLine();
			System.out.println("-----Enter Password------");
			String password = scan.nextLine();

										//set to 0 due to sequence and trigger.
			String x = username;
			String y = password;

			if(Logic.validateUser(username,password)) {
				if(Logic.loginAcc(User.getUser().getUsers_id())) {
				return new AccountMenu();
				}System.out.println("User Account not found!");
				return this;
			}return this;
			
		}}