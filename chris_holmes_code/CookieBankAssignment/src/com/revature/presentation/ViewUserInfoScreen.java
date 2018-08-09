package com.revature.presentation;

import java.util.Scanner;

import com.revature.Dao.TransDao;
import com.revature.interfaces.Screen;

public class ViewUserInfoScreen implements Screen{

	@Override
	public Screen start() {
		System.out.println("View User info");
		Scanner scan = new Scanner(System.in);//making a new scanner to scan input
		System.out.println("Press 1 to view user last name");
		int input = scan.nextInt();
		switch (input) {
		case 1:
			
		return this.start();
	}
		return null;

	}
}
