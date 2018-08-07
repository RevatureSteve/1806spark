package com.dimma.logic;

import com.dimma.dao.Dao;
import com.dimma.dao.DaoInterface;
import com.dimma.presentation.AccountMenu;
import com.dimma.presentation.LoginMenu;
import com.dimma.user.Account;
import com.dimma.user.User;

public class Logic {
	static Dao DimmaDao = new Dao();
	
	public static boolean validateUser(String username, String password) {
		
		if(DimmaDao.loginUser(username,password) != null) {
			if((User.getUser().getPassword()).equals(password)){
				System.out.println("|-------------------|");
				System.out.println("|Password confirmed!|");
				System.out.println("|-------------------|");
				return true;	
			}
		}
		System.out.println("|-------------------------------------|");
		System.out.println("|Password Incorrect, please try again.|");
		System.out.println("|-------------------------------------|");
		return false;		
	}
	public static boolean loginAcc(int users_id) {
		if((DimmaDao.loginAcc(users_id)) != null) {
			
			return true;
		}
		System.out.println("|-------------------------------|");
		System.out.println("|FATAL ERROR, ACCOUNT NOT FOUND.|");
		System.out.println("|-------------------------------|");
		return false;
	}
	
	public static boolean depositFunk(int amt, int users_id) {
		if(DimmaDao.depositFunk(amt,users_id) > 0) {
			System.out.println("|----------------------------------|");
			System.out.println("|Deposit of $" + amt + " confirmed.|");
			System.out.println("|----------------------------------|");
			return true;
		}
		System.out.println("|-----------------------|");
		System.out.println("|----DATABASE ERROR!----|");
		System.out.println("|-----------------------|");
		return false;
	}
	public static boolean withdrawFunk(int amt, int users_id) {
		if(Account.withdrawAcc(amt)) {
		if(DimmaDao.withdrawFunk(amt,users_id) > 0) {
		System.out.println("|-----------------------------------|");
		System.out.println("/          | Withdraw of |          /");
		System.out.println("|          | of $" + amt + "|        |");
		System.out.println("/          |  confirmed. |           / ");
		System.out.println("|-----------------------------------|");
			return true;
		}
		System.out.println("| --------------------------------- |");
		System.out.println("O           !   !   !  !  !         O");
		System.out.println("|          !!    DB ERR!!        |");
		System.out.println("O           !   !      !  !             O");
		System.out.println("| --------------------------------- |");
		return false;
	}
		System.out.println("  ---------------------------------   ");
		System.out.println("/   _                               / ");
		System.out.println("|  [X]                              | ");
		System.out.println("/  [X]                              / ");
		System.out.println("|  [X]  OVERDRAFT DETECTED!         | ");
		System.out.println("/   _    REQUEST DENIED,            / ");
		System.out.println("|  [X]      NEGATIVE $              | ");
		System.out.println("/           "+ (-(Account.acc.getBalance()-amt)));
		System.out.println("|-----------------------------------|");
		return false;
	}
	public static boolean transactionFunk(int account_number,int type) {
		if(DimmaDao.transFunk(account_number,type) != null) {
			return true;
		}
		return false;

	}
	
	
}
