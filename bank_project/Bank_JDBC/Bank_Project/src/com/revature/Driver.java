package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.buisnesslogic.BuisnessLogic;
import com.revature.exceptions.NotEnoughMoneyException;
import com.revature.present.EnterScreen;
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

		new EnterScreen().start();

	}

}
