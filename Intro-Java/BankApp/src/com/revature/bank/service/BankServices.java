package com.revature.bank.service;

import com.revature.bank.dao.BankDao;
import com.revature.bank.dao.BankDaoImpl;
import com.revature.bank.pojo.User;

public class BankServices {
	
private static BankDao bDao = new BankDaoImpl();
	
	public User login(User u) {
		User dbUser = bDao.getUser(u.getUsername());
		if(dbUser != null) {
			if(dbUser.getPassword().equals((u.getPassword()))){
				return dbUser;
			}
			
		}
		return null;
	}
	
	public static void balDeposite(double userin, User db_u) {
		double dep = userin + db_u.getBalance();
		bDao.UpdateBalance(db_u, dep);
		System.out.println("$" + userin + " have been deposited.");
		System.out.println("Your new balance is: $" + db_u.getBalance());
		bDao.createTransactionType(1);
		bDao.createTransaction(userin, db_u.getU_id());
	}
	
	public static void balWithdral(double userin, User db_u) {
		bDao.UpdateBalance(db_u, db_u.getBalance() - userin);
		System.out.println("$" + userin + " has been withdrawn.");
		bDao.getAccountBalance(db_u);
		System.out.println("Your new balance is: $" + db_u.getBalance());
		bDao.createTransactionType(2);
		bDao.createTransaction(userin, db_u.getU_id());
	}
}
