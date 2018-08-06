package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;

public class RegisterScreen implements Screen {
	
	public Screen Start() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("the registration page");
		System.out.println("enter new username");
		scan.nextLine();
		System.out.println("enter new registration");
		scan.nextLine();
		
		
		return null;
	}

}
