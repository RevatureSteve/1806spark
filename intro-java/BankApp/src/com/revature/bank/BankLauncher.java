package com.revature.bank;

import com.revature.bank.dao.BankDao;
import com.revature.bank.exceptions.NoInputException;
import com.revature.bank.pojo.User;
import com.revature.bank.presentation.Presentation;

public class BankLauncher {
	public static void main(String[] args) {
		
		BankDao bDao = new BankDao();
		User u = null, db_u = null;
		double userin;

		
		while(true) {
			try {
				u = Presentation.login();
			} catch (NoInputException e) {
				System.out.println("Im gonna need that information if you want to access your account.");
				e.printStackTrace();
			}
			db_u = bDao.getUser(u.getUsername());
			if(db_u != null) {
				bDao.getBalance(db_u);
				System.out.println("Ah yes! Welcome back " + db_u.getFirstName() + " " + db_u.getLastName());
				break;
			}
			System.out.println("Sorry but I cant find you in my records. please try again.");
		}
		
		
		while(true) {
			String input = Presentation.UserMainMenu();
			switch(input) {
			case "1":
				System.out.println("Your balance is: $" + Presentation.ViewBalance(db_u));
				break;
			case "2":
				userin = Double.parseDouble(Presentation.Deposit());
				double dep = userin + db_u.getBalance();
				bDao.UpdateBalance(db_u, dep);
				System.out.println("$" + userin + " have been deposited.");
				System.out.println("Your new balance is: $" + db_u.getBalance());
				bDao.createTransactionType(1);
				bDao.createTransaction(userin, db_u.getU_id());
				
				break;
			case "3":
				userin = Double.parseDouble(Presentation.Withdrawl(db_u));
				if (userin > db_u.getBalance()) {
					System.out.println("Im sorry but you dont have that much. try again?");
					Presentation.UserMainMenu();
				}
				bDao.UpdateBalance(db_u, db_u.getBalance() - userin);
				System.out.println("$" + userin + " has been withdrawn.");
				bDao.getBalance(db_u);
				System.out.println("Your new balance is: $" + db_u.getBalance());
				bDao.createTransactionType(2);
				bDao.createTransaction(userin, db_u.getU_id());
				break;
			case "x":
				System.out.println("Ok. thank you for stopping by!");
				System.exit(0);
			default:
				System.out.println("Sorry I didnt quite get that.");
			}
		}
	}
}
