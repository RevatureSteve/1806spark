package com.revature;

import java.util.Scanner;

import com.revature.dao.BankDaoImpl;
import com.revature.pojo.Bank_Account;
import com.revature.pojo.Users;

import Presentation.MainMenus;

public class Driver {

	public static void main(String[] args) {
		BankDaoImpl x = new BankDaoImpl();
//		System.out.println(x.getUserByUsername("PvtMad"));

		Scanner scan = new Scanner(System.in);
		while (true) {
			MainMenus.welcomeMenu();
			int userInput = scan.nextInt();
			switch (userInput) {
			case 1:
				MainMenus.createUserCardMenu(); // Because it's static, use dot operator to obtain that method
				break;

			case 2:
				Users a = MainMenus.logInscreen();

				// To stay within the usersInformation screen
				boolean exit = true;
				while (exit) {
					int usersChoice = MainMenus.usersInformation(a);

					switch (usersChoice) {
					case 1:
						int amount = MainMenus.depositScreen(a);
						x.depositing(a, amount);
						continue;
					case 2:
						int withdraw = MainMenus.withdrawScreen(a);
						
						x.withdrawing(a, withdraw);
						continue;
					case 3:
						Bank_Account b = x.getBalance(a);
						MainMenus.viewBalance(b);
						continue;
					case 4:
						MainMenus.signOutScreen();
						exit = false;
					}
					break;
				}
				break;

			case 3:
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("******************                                                        *****************");
				System.out.println("******************                     LEAVING VAULT 101                  *****************");
				System.out.println("******************                                                        *****************");
				System.out.println("******************                        Thank you!                      *****************");
				System.out.println("******************                                                        *****************");
				System.out.println("******************     And be careful, stay away from the deathcrawlers   *****************");
				System.out.println("******************                                                        *****************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("*******************************************************************************************");
				System.out.println("Property of Vault-Tec**********************************************************************");
				System.out.println("Vault-Tec Corporate Headquaters************************************************************");
				System.out.println("Washington D.C*****************************************************************************");
				System.out.println("Vault 101 Commonwealth Bank access machine*************************************************");
				System.out.println("Contact Vault Overseer for needed assistance***********************************************");
				System.out.println("*******************************************************************************************");
				System.exit(1);
			}
		}

	}
}
