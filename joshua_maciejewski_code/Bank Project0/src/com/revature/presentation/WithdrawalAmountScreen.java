package com.revature.presentation;

import java.util.Scanner;

import com.revature.dao.AccountInfoDaoImpl;
import com.revature.dao.BankDao;
import com.revature.dao.WithdrawalDaoImpl;
import com.revature.logic.BusinessLogic;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;




public class WithdrawalAmountScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	
	BankDao dao = new AccountInfoDaoImpl();
	BankAccount acc = dao.getAccountInfo(Users.potentialUser().getUserId());
	
	BankDao withdrawalDao = new WithdrawalDaoImpl();
	
	int accNum = acc.getAccountNumber();
	double currentBalance = acc.getBalance();
	
	
	
	
	public Screen start()  {
		
	
		System.out.println("How much would you like to withdraw??");
		
		double input = scan.nextDouble();
		
			
		if(BusinessLogic.noNegativeBalance(currentBalance, input)) {
			
			withdrawalDao.enterWithdrawal(input, accNum);
			
		} else {
			System.out.println("You don't have that much money");
			return this;
		}
		
			
		
		return new WithdrawalConfirmation();
	}

}

// public class DepositAmountScreen implements Screen {
//
//private Scanner scan = new Scanner(System.in);
//
//BankDao dao = new AccountInfoDaoImpl();
//BankAccount acc = dao.getAccountInfo(Users.potentialUser().getUserId());
//
//BankDao DepositDao = new DepositDaoImpl();
//int accNum = acc.getAccountNumber();
//
//public Screen start() {
//	System.out.println("How much would you like to deposit??");
//	
//	double input = scan.nextDouble();
//	
//	DepositDao.enterDeposit(input, accNum);
//	
//	
//	return new DepositConfirmation();
//}
//
//}
