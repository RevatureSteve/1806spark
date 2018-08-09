package com.cpo.screens;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cpo.SessionManager;
import com.cpo.animation.TextAnimation;
import com.cpo.beans.Account;
import com.cpo.beans.Transaction;
import com.cpo.beans.User;
import com.cpo.color.Colors;
import com.cpo.dao.AccountDatabaseDao;
import com.cpo.dao.TransactionDatabaseDao;

public class TransactionScreens {

	public static void transactionHistory() {
		Scanner scan = new Scanner(System.in);
		TextAnimation.leftToRightText("Getting Transaction History...");
		List<Account> accounts = AccountSummary.selectAccounts();
		
		List<Integer> accountNumbers = new ArrayList<Integer>();
		
		for (Account account: accounts) {
			accountNumbers.add(account.getAccountNumber());
		}
		
		List<Transaction> txs = TransactionDatabaseDao.getInstance().getTransactions(accountNumbers);
		
		for ( Transaction tx: txs) {
			if (tx.getTxTypeId() == 1)
				TextAnimation.leftToRightText(Colors.GREEN + " - " + tx.prettyPrint() +  Colors.RESET);
			else
				TextAnimation.leftToRightText(Colors.RED + " - " + tx.prettyPrint() +  Colors.RESET);
		}
		
		TextAnimation.leftToRightText("All done! Press enter to continue...");
		scan.nextLine();
		AccountSummary.accountSummary();
	}
	
	public static void depositTransaction() {
		saveTransaction("deposit", 1);
	}
	
	public static void withdrawTransaction() {
		saveTransaction("withdraw", 2);
	}
	
	private static void saveTransaction(String type, int typeId) {
		Scanner scan = new Scanner(System.in);
		TextAnimation.leftToRightText("Let's " + type + " some money!");
		Account account = AccountSummary.selectAccount();
		TextAnimation.leftToRightText("How much do you want to " + type + "?");
		long amount = Screens.nextInt();
	
		//Check for negative numbers
		if (amount < 0) {
			TextAnimation.blinkingCursor("Why are you entering a negative number?");
			saveTransaction(type, typeId);
			return;
		}
		
		//Check for no number
		if (amount == 0) {
			TextAnimation.blinkingCursor("No transaction will be created, redirecting to account summary");
			AccountSummary.accountSummary();
			return;
		}
		
		if (typeId == 2) {
			//withdrawal check
			if (account.getBalance() < amount) {
				TextAnimation.blinkingCursor("Not enough money to withdraw");
				saveTransaction(type, typeId);
				return;
			}
			else {
				account.setBalance( account.getBalance() - amount);
			}
		}
		else if (typeId == 1) {
			account.setBalance(account.getBalance() + amount);
		}
		
		TextAnimation.leftToRightText("Saving transaction...");
		
		//Update account
		AccountDatabaseDao.getInstance().updateAccount(account);
		updateAccounts();
		//Save transaction
		Transaction tx = new Transaction(typeId, new Timestamp(new Date().getTime()), account.getAccountNumber(), amount);
		TransactionDatabaseDao.getInstance().createTransactions(tx);
		TextAnimation.blinkingCursor("Transaction saved! ($" + amount + ")");
		AccountSummary.accountSummary();
	}
	
	private static void updateAccounts() {
		User user = SessionManager.getLoggedInUser();
		SessionManager.setAccounts(AccountDatabaseDao.getInstance().getAccounts(user.getUserId()));
	}
}
