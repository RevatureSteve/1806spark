package com.cpo.screens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cpo.SessionManager;
import com.cpo.animation.TextAnimation;
import com.cpo.beans.Account;
import com.cpo.beans.User;
import com.cpo.color.Colors;
import com.cpo.dao.AccountDatabaseDao;

/**
 * Account Summary screens for the user.
 * User should already be set in SessionManager.
 * @author chin2
 *
 */
public class AccountSummary {

	public static void accountSummary() {
		
		//Pull accounts from the database
		List<Account> accounts = getAccounts();
		SessionManager.setAccounts(accounts);
		
		if (accounts.size() > 0) {
			TextAnimation.topToBottomText(Colors.GREEN_BOLD_BRIGHT + "\r\n" + 
					"             _____   _____   ____  _    _  _   _ _______ \r\n" + 
					"     /\\     / ____| / ____| / __ \\| |  | || \\ | |__   __|\r\n" + 
					"    /  \\   | |     | |     | |  | | |  | ||  \\| |  | |   \r\n" + 
					"   / /\\ \\  | |     | |     | |  | | |  | || . ` |  | |   \r\n" + 
					"  / ____ \\ | |____ | |____ | |__| | |__| || |\\  |_ | |   \r\n" + 
					" /_/    \\_(_)_____(_)_____(_)____(_)____(_)_| \\_(_)|_|   \r\n" + 
					"");
			TextAnimation.leftToRightText("------A Closed Case fOr yoUr Needed Transactions------");
			System.out.println();
			TextAnimation.leftToRightText(Colors.GREEN + "Total balance: $" + getTotalBalance(accounts));
			TextAnimation.leftToRightText("Accounts: " + accounts.size());
			TextAnimation.leftToRightText("1) View transaction history");
			TextAnimation.leftToRightText("2) View account balances");
			TextAnimation.leftToRightText("3) Add an account");
			TextAnimation.leftToRightText(Colors.GREEN + "4) Add money" + Colors.RESET);
			TextAnimation.leftToRightText(Colors.RED + "5) Withdraw money" + Colors.RESET);
			TextAnimation.leftToRightText(Colors.YELLOW + "6) Logout");
			TextAnimation.leftToRightText("7) Exit");
			
			int menuSelect =  Screens.nextInt();
			
			switch(menuSelect) {
			case 1:
				TransactionScreens.transactionHistory();
				break;
			case 2:
				viewAccounts();
			case 3:
				createAccounts();
				break;
			case 4:
				TransactionScreens.depositTransaction();
				break;
			case 5:
				TransactionScreens.withdrawTransaction();
				break;
			case 6:
				SessionManager.resetSession();
				Screens.welcome();
				break;
			case 7:
				TextAnimation.blinkingCursor("Goodbye agent");
				System.exit(1);
				break;
			default:
				TextAnimation.blinkingCursor("Please enter something meaningful next time");
				TextAnimation.leftToRightText("Now watch the whole page load hahaha");
				accountSummary();
			}
				
			
		}
		else {
			createAccounts();
		}
	}

	private static void createAccounts() {
		TextAnimation.leftToRightText(Colors.CYAN + "Lets add an account!");
		TextAnimation.leftToRightText("Initial balance:");
		long initBalance = Screens.nextInt();
		if (initBalance < 0) {
			TextAnimation.blinkingCursor("Why enter a negative number???");
			createAccounts();
			return;
		}
		TextAnimation.leftToRightText("Great, creating account...");
		Account account = new Account(initBalance,SessionManager.getLoggedInUser().getUserId());
		AccountDatabaseDao.getInstance().createAccount(account);
		TextAnimation.leftToRightText("Done! Create another account?");
		TextAnimation.leftToRightText("1) No...");
		TextAnimation.leftToRightText("2) Yes!");
		
		int menuSelect = Screens.nextInt();
		
		User user = SessionManager.getLoggedInUser();
		
		switch(menuSelect) {
		case 1:
			SessionManager.setAccounts(AccountDatabaseDao.getInstance().getAccounts(user.getUserId()));
			TextAnimation.blinkingCursor("Going to account summary");
			accountSummary();
			break;
		case 2:
			createAccounts();
			break;
		default:
			TextAnimation.leftToRightText("Come on agent, you only had 2 choices...");
			SessionManager.setAccounts(AccountDatabaseDao.getInstance().getAccounts(user.getUserId()));
			TextAnimation.blinkingCursor("Going to account summary");
			accountSummary();
		}
		
	}

	private static Long getTotalBalance(List<Account> accounts) {
		long totalBalance = 0;
		for (Account account: accounts) {
			totalBalance += account.getBalance();
		}
		return totalBalance;
	}
	
	private static List<Account> getAccounts(){
		if (SessionManager.getAccounts() == null || SessionManager.getAccounts().isEmpty()) {
			User user = SessionManager.getLoggedInUser();
			SessionManager.setAccounts(AccountDatabaseDao.getInstance().getAccounts(user.getUserId()));
		}
		return SessionManager.getAccounts();
	}
	
	public static List<Account> selectAccounts(){
		List<Account> accounts = getAccounts();
		int i = 1;
		
		TextAnimation.leftToRightText(Colors.PURPLE + "Select Account(s):");
		for (;i < accounts.size() + 1; i++) {
			TextAnimation.leftToRightText(i + ") Account " + accounts.get(i - 1).getAccountNumber() + " $" + accounts.get(i - 1).getBalance());
		}
		TextAnimation.leftToRightText(i + ") Select All");
		

		int menuSelect = Screens.nextInt();
		if (menuSelect < i && menuSelect > 0) {
			List<Account> list = new ArrayList<Account>();
			list.add(accounts.get(menuSelect - 1));
			return list;
		}
		else {
			TextAnimation.blinkingCursor("Selecting All");
			return accounts;
		}

	}
	
	public static Account selectAccount() {
		List<Account> accounts = getAccounts();
		int i = 1;
		
		TextAnimation.leftToRightText(Colors.PURPLE + "Select Account:");
		for (;i < accounts.size() + 1; i++) {
			TextAnimation.leftToRightText(i + ") Account " + accounts.get(i - 1).getAccountNumber() + " $" + accounts.get(i - 1).getBalance());
		}
		
		int menuSelect = Screens.nextInt();
		if (menuSelect < i && menuSelect > 0) {
			return accounts.get(menuSelect - 1);
		}
		else {
			return selectAccount();
		}
	}
	
	public static void viewAccounts() {
		
		List<Account> accounts = getAccounts();
		TextAnimation.leftToRightText("Here are your accounts (" + accounts.size() + ")");
		
		for (int i = 1;i < accounts.size() + 1; i++) {
			TextAnimation.leftToRightText(i + ") Account " + accounts.get(i - 1).getAccountNumber() + " $" + accounts.get(i - 1).getBalance());
		}
		continueText();
		accountSummary();
	}
	
	public static void continueText() {
		Scanner scan = new Scanner(System.in);
		TextAnimation.leftToRightText("Press enter to continuee...");
		scan.nextLine();
	}

}
