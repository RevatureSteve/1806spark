package com.revature.presentation;

import java.util.Scanner;

import com.revature.dao.AccountInfoDaoImpl;
import com.revature.dao.BankDao;
import com.revature.dao.DepositDaoImpl;
import com.revature.logic.BusinessLogic;
import com.revature.pojo.BankAccount;
import com.revature.pojo.Users;


public class DepositAmountScreen implements Screen {

	private Scanner scan = new Scanner(System.in);
	
	BankDao dao = new AccountInfoDaoImpl();
	BankAccount acc = dao.getAccountInfo(Users.potentialUser().getUserId());
	
	BankDao DepositDao = new DepositDaoImpl();
	int accNum = acc.getAccountNumber();
	
	
	
	public Screen start() {
		System.out.println("How much would you like to deposit?");
		
		double input = scan.nextDouble();
		
				
		if(BusinessLogic.noNegativeValue(input))  {
			DepositDao.enterDeposit(input, accNum);
		} else {
			
			System.out.println("You can't deposit a negative number");
			return this;
		}
		
		
		
		return new DepositConfirmation();
	}

}



//	
	
	