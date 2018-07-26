package bank;

import java.util.Scanner;
import bank.pin;

public class pinMenu implements Screen {

private Scanner scan = new Scanner(System.in);
	
	@Override
		public Screen start() {
		// most likely would be pulled from the database.
		System.out.println("WELCOME LOYAL CUSTOMER.");
		System.out.println("Please input your pin number");
			System.out.println("or press '2' to return to the main screen");
			String input = scan.nextLine();

			switch (input) {
			case pin:
				System.out.println("Welcome!");
				return new accountScreen();
				break;
			case "2":
				return new MainScreen();
			}

			// TODO Auto-generated method stub
			return this;
	}

}
