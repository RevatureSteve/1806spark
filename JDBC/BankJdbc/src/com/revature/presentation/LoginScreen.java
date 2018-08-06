package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;

public class LoginScreen implements Screen {

	@Override
	public Screen Start() {
		Scanner scan = new Scanner(System.in);
		System.out.println("the login page");
		System.out.println("enter username");
		String userName = scan.nextLine();
		System.out.println("enter password");
		String password = scan.nextLine();
		return this;
	}

}
