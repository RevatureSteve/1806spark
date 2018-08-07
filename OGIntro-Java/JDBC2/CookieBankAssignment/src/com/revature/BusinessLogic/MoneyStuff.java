package com.revature.BusinessLogic;

import java.util.List;

import com.revature.Dao.CookieAccountDao;
import com.revature.Dao.UserDataAccess;
import com.revature.Exceptions.DontDoThatException;
import com.revature.pojos.CookieAccount;
import com.revature.pojos.Cookieuser;

public class MoneyStuff {

	public static boolean userPresence(String usename, String pw) {
		UserDataAccess userdata = new UserDataAccess(); //makes a new DAO
		List<Object> listofusers = userdata.read(); //reads from the current list of users
		for (Object obj : listofusers) {
			Cookieuser cookieuser = (Cookieuser) obj;//makes a new user object
					if (usename.equals(cookieuser.getUsename())&& pw.equals(cookieuser.getPw())) {
						// if the username from the new object equals the username in the database
						Cookieuser.setCurrentCookie(cookieuser);
						// then set the user object to the user in the database
						return true;
					}
		
			}
		return false;
		
	}
	//Finds the current users bank account
	//accesses it so that we can do things to it

	public static void findTheAccountAltertheCookies(int useId) {
		CookieAccountDao caDao = new CookieAccountDao();
		CookieAccount usersaccount = caDao.getbyId(useId);
		CookieAccount.setCurrentAcct(usersaccount);
	}
	


	public static void recieveCookies(int amt) throws DontDoThatException { //the withdrawal function
		CookieAccount act = CookieAccount.getCurrentAcct();//grabs the users account from the db
		int bal = act.getBal();// gets the current users balance
		if(bal - amt >0) { // the users balance must be greater than 0
			act.setBal((int) (bal - amt));// set the users balance to whatever I take out
			new CookieAccountDao().update(act);// update the account balance to the finished product
		}else if (amt > bal) {
			System.out.println("no, you cant do that");
		}
			
		
	}
	
	public static void depositCookies(int amt) {
		CookieAccount act = CookieAccount.getCurrentAcct();//grabs current account
		int bal = act.getBal();// gets current balance
		act.setBal((int) (bal + amt));//set the balance to the current balance plus whatever amount the user adds in
		new CookieAccountDao().update(act);//update the users balance after that
	}

	
}
