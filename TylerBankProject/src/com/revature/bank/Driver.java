package com.revature.bank;

import java.util.Scanner;

import com.revature.bank.pojo.UsersPojo;

public class Driver  {
	
	private static final String USERNAME= "bank_db";
	private static final String PASSWORD= "p4ssw0rd";
	private static final String URL= "jdbc:oracle:thin:@tylertraining.cnmoc1mujdcw.us-east-2.rds.amazonaws.com:1521:ORCL";

	public static void main(String[] args) {


	Scanner scan = new Scanner(System.in);
	
	
	
    UsersPojo user = BankPresentationUtil.loginSwitch();
	
    System.out.println("Welcome to the Iron Bank of Braavos, " + user.getFname() + " " + user.getLname());
    
	BankPresentationUtil.mainMenu();
	
		
		
	
	}

}

