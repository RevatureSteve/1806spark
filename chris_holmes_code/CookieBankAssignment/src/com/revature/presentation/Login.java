package com.revature.presentation; //2
import com.revature.pojos.CookieAccount;
import com.revature.pojos.Cookieuser;

import java.util.List;
import java.util.Scanner;

import com.revature.BusinessLogic.MoneyStuff;
import com.revature.Dao.CookieAccountDao;
import com.revature.interfaces.Screen;


public class Login implements Screen{

@Override
public Screen start() {
	Scanner scan = new Scanner(System.in);//takes user input
	
	System.out.println("LOGIN FOR COOKIES");
	System.out.println("Enter username");
	String usename = scan.nextLine();//returns next string
	System.out.println("Enter password:" );
	String pw = scan.nextLine();
	
	if (MoneyStuff.userPresence(usename, pw)) {
		CookieAccountDao cdao = new CookieAccountDao(); //makes new instance of CookieAccountDao
		CookieAccount ca = null; //new instance of cookieAccount, set to null so we can use it later outside of scope
		int userId = Cookieuser.getCurrentCookie().getId(); //gets the ID of the current user
		List<Object> cookieaccounts = cdao.read(); // gets all accounts and makes a list of them
		for(Object cookieaccount : cookieaccounts) { // iterates through all cookie accounts
			ca = (CookieAccount) cookieaccount;//whatever object im currently on in the databse
			if (ca.getUserId() == Cookieuser.getCurrentCookie().getId()) { // if the user in the database is identical with the user logging in then stop the loop
				break;
			}
			
		}
		CookieAccount.setCurrentAcct(ca); // sets out singleton account to be accessible anywhere
		return new MainMenu().start();
	}
	System.out.println("Try Again"); //If not then get the user to try again
	return this.start();
}
	
}
