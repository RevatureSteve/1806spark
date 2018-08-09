/**
 * 
 */
package com.revature;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.database.DataBankDoa;
import com.revature.database.Doa;
import com.revature.pojo.Account;
import com.revature.pojo.ToolCool;
import com.revature.pojo.Users;

/**
 * @author sethc
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Doa bank = new DataBankDoa();

		Scanner scan = new Scanner(System.in);



		ToolCool.welcome();

		Users user = ToolCool.login();



		while (true) {
try {
			ToolCool.someMenu();

			int input = scan.nextInt();



			switch (input) {

			case 1:

				ToolCool.deposit(user.getUsersId());

				break;

			case 2:

				ToolCool.withdraw(user.getUsersId());

				break;

			case 3:

				bank.getAccountInfo(user.getUsersId());
				Account acc = Account.accountSingleton();
				System.out.println("Your balance is: " +acc.getBalance());
				break;

			case 4:

				System.out.println("I hope You Were Please!!");
				System.out.println("Thank you for using Chester's Bank");
				System.out.println("Did I hear Front End calling!!!");
				System.out.println("When i say Spaghetti... You say");
				System.out.println("Loop");
				System.exit(1);

				break;

			default:

				System.out.println("Sorry that is not a valid number from the options given.");

				break;

			}

		} 
catch (InputMismatchException e) {
		System.out.println("Please Select, press enter to continue... ");}
		scan.nextLine();



	




		
		
	}

}
}
