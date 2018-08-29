package com.revature.presentation;
import java.util.Scanner;

public class UserView {
	
	String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.
	Scanner input = new Scanner(System.in);
	TransactionsView tView = new TransactionsView();
//	AdministrationView aView = new AdministrationView();
	
	public void customerView(String username)
	{
		
		int choice;
		System.out.println("********************************************************" + newLine);
		System.out.println("Welcome to the menu. What would you like to do?");
		System.out.println("1. Create an account" + newLine + "2. Check accounts "+ newLine + "3. Withdraw vibranium" + newLine + "4. Deposit vibrainium" + newLine + "5. Close an account" + newLine + "6. Logout"+ newLine);
		System.out.println("********************************************************" + newLine);
			 while(!input.hasNextInt())
		     {
		    	 String input1 = input.nextLine();
		    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Please enter a number from one of the options above.", input1);
		     }
			 choice = input.nextInt();
			 
			 switch(choice)
			 {
			 
			 	case 1:
			 		//continue to create account
			 		tView.createAccount(username);
			 		customerView(username);
			 		break;
			 	case 2:
			 		//continue to check accounts
			 		tView.checkAccounts(username);
			 		customerView(username);
			 		break;
			 	case 3:
			 		//continue to withdraw
			 		tView.withdraw(username);
			 		customerView(username);
			 		break;
			 	case 4:
			 		//continue to deposit
			 		tView.deposit(username);
			 		customerView(username);
			 		break;
			 	case 5:
			 		//continue to close account
			 		tView.closeAccount(username);
			 		customerView(username);
			 		break;
			 	case 6:
			 		//exit
			 		System.out.println("Logging out...");
        			break;
			 	default:
			 		//error message
        			System.out.println("Select one of the options from above." + newLine);
        			break;
			 }
			 
		
	}
	
//	public void adminView(String username)
//	{
//		int choice;
//		System.out.println("*****************************************************************" + newLine);
//		System.out.println("Welcome to the admin menu. What would you like to do?");
//		System.out.println("1. View Users"+ newLine + "2. Create users "+ newLine + "3. Update Users" + newLine + "4. Delete Users" + newLine + "5. Logout" + newLine);
//		System.out.println("*****************************************************************" + newLine);
//		 while(!input.hasNextInt())
//	     {
//	    	 String input1 = input.nextLine();
//	    	 System.out.printf("\"%s\" is not a valid selection.\n" + newLine + "Please enter a number from one of the options above.", input1);
//	     }
//		 choice = input.nextInt();
//		 
//		 switch(choice)
//		 {
//		 	case 1:
//		 		//continue to view users
//		 		aView.viewUsers(username);
//		 		break;
//		 	case 2:
//		 		//continue to create users
//		 		aView.createUsers(username);
//		 		break;
//		 	case 3:
//		 		//continue to update users
//		 		aView.updateUsers(username);
//		 		break;
//		 	case 4:
//		 		//continue to delete users
//		 		aView.deleteUsers(username);
//		 		break;
//		 	case 5:
//		 		//exit
//		 		System.out.println(newLine + "Logging Out..");
//    			break;
//		 	default:
//		 		//error message
//    			System.out.println("Select one of the options from above." + newLine);
//    			break;
//		 }
	}


