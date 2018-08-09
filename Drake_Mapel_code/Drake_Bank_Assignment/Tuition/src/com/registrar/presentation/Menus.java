package com.registrar.presentation;

import java.util.Scanner;

import com.registrar.Tuition_Driver;
import com.registrar.dao.TuitionDao;
import com.registrar.dao.TuitionDaoImpl;
import com.registrar.pojo.Account;
import com.registrar.pojo.User;
import com.registrar.service.LoginService;

public class Menus {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static void options() {
		System.out.println("Enter 1 to create user");
		System.out.println("Enter 2 to login");
		System.out.println("Enter any key to exit");
	}
	
	public static void subOptions() {
		System.out.println("Enter 1 to create account");
		System.out.println("Enter 2 to view balance");
		System.out.println("Enter 3 to add a class");
		System.out.println("Enter 4 to drop class(es)");
		System.out.println("Enter any key to logout");
	}
	
	public static void input() {
		Scanner scanInp = scan;
		int inp = scanInp.nextInt();
		
		switch (inp) {
		case 1:
			createUserMenu();
			break;
		case 2:
			User s = login();
			System.out.println("Welcome " + s.getFname());
			subMenu(s.getUsers_id());
			System.out.println("logging out");
			break;
		default:
			Tuition_Driver.session = false;
		}
	}
	
	public static void welcome() {
		System.out.println("***************************************");
		System.out.println("*Welcome to the Office of the Registrar*");
		System.out.println("*****************************************");
	}
	
	public static void createUserMenu() {

		Scanner scanMenu = scan;
		System.out.println("---Creating a User---");
		System.out.println("Choose your username");
		String username = scanMenu.next();
		System.out.println("Enter a password");
		String password = scanMenu.next();
		System.out.println("Enter your first name");
		String fname = scanMenu.next();
		System.out.println("Enter your last name");
		String lname = scanMenu.next();
		
		System.out.println("Processing...");
		User u = new User(0, username, password, fname, lname);
		TuitionDao tdao = new TuitionDaoImpl();
		tdao.createUserProc(u);

	}
	
	public static User login() {
		System.out.println("Please enter username");
		String username = scan.next();
		System.out.println("Enter password");
		String pw = scan.next();
		System.out.println("please wait");
		User validUser = new LoginService().login(new User( 0, username, pw, "", "" ));
		return validUser;
	}
	
	public static void subMenu(int u_id) {
		
		boolean subsession = true;
		
		int subInp;
		int dropInp;
		
		while (subsession) {
			subOptions();
			subInp = scan.nextInt();
			
			switch (subInp) {
			case 1:
				createAccountMenu(u_id);
				System.out.println("account created");
				break;
			case 2:
				TuitionDao tdao = new TuitionDaoImpl();
				tdao.viewBalance(u_id);
				break;
			case 3:
				TuitionDao tdao2 = new TuitionDaoImpl();
				tdao2.addClass(u_id);
				break;
			case 4:
				System.out.println("How many classes would you like to drop?");
				dropInp = scan.nextInt();
				TuitionDao tdao3 = new TuitionDaoImpl();
				tdao3.dropClasses(dropInp, u_id);
				break;
			default:
				subsession = false;
				break;
			}
			
		}

	}
	
	public static void createAccountMenu(int u_id) {
		System.out.println("---Creating an Account---");
		Account ac = new Account(0,0,u_id);
		TuitionDao tdao = new TuitionDaoImpl();
		tdao.createStudentAccountProc(ac);
	}

}
