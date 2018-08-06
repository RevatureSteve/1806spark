package com.revature;

import java.util.Scanner;

import com.revature.present.LoginScreen;
import com.revature.present.RegisterScreen;

public class Driver {

	public static void main(String[] args) {

		System.out.println(
				" __      __   _                    _         _____                 _         _      ___            _    \r\n"
						+ " \\ \\    / /__| |__ ___ _ __  ___  | |_ ___  |_   _| _ __ ___ _____| |___ _ _( )___ | _ ) __ _ _ _ | |__ \r\n"
						+ "  \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) |  _/ _ \\   | || '_/ _` \\ V / -_) / -_) '_|/(_-< | _ \\/ _` | ' \\| / / \r\n"
						+ "   \\_/\\_/\\___|_\\__\\___/_|_|_\\___|  \\__\\___/   |_||_| \\__,_|\\_/\\___|_\\___|_|   /__/ |___/\\__,_|_||_|_\\_\\ \r\n"
						+ "                                                                                                        ");

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("Already a user. Enter 1 to login:");
			System.out.println("New user. Enter 2 to create an account:");
			int userInput = scan.nextInt();
			
			switch(userInput) {
				case 1:
					new LoginScreen().start();
				case 2:
					new RegisterScreen().start();
			}

		}

}

}
