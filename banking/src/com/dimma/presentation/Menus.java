package com.dimma.presentation;

import java.util.Scanner;

import com.dimma.user.User;

public class Menus {
	public static void welcome() {
		System.out.println("*******");
		System.out.println("*Hello*");
		System.out.println("*******");
	}
	
	public static User loginUser() {
		Scanner scan = new Scanner(System.in);
		System.out.println("---Please Login---");
		System.out.println("----Enter Username-----");
		String username = scan.nextLine();
		System.out.println("-----Enter Password------");
		String password = scan.nextLine();

									//set to 0 due to sequence and trigger.
		User user = new User(username,password);
		return user;
	}
}
