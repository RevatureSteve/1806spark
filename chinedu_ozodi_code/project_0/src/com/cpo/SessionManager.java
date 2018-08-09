package com.cpo;

import java.util.List;

import com.cpo.beans.Account;
import com.cpo.beans.User;

public class SessionManager {

	private static User loggedInUser;
	
	private static List<Account> accounts;

	public static List<Account> getAccounts() {
		return accounts;
	}
	
	public static void resetSession() {
		loggedInUser = null;
		accounts = null;
	}

	public static void setAccounts(List<Account> accounts) {
		SessionManager.accounts = accounts;
	}

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User loggedInUser) {
		SessionManager.loggedInUser = loggedInUser;
	}
}
