package com.revature.io;

import java.util.Scanner;

import com.revature.Serialization;
import com.revature.abstracts.MathTeam;
import com.revature.classes.WinningMathTeamAB;
import com.revature.classes.WinningMathTeamBA;
import com.revature.runnable.DeserializeRunnable;

public class IOHandler {
	public static void getInputs(Scanner scan) {
		System.out.println("Select from the menu:");
		System.out.println("1 for read Previous Team");
		System.out.println("2 for create new winning team");
		System.out.println("3 does the Previous Team like cupcakes");
		System.out.println("4 for performing math");
		int menu1 = scan.nextInt();
		if (menu1 == 1) {
			DeserializeRunnable des = new DeserializeRunnable();
			Thread t = new Thread(des);
			t.start();
		} else if (menu1 == 2) {
			System.out.println("Select from the menu:");
			System.out.println("1 for Winning Math Team AB");
			System.out.println("2 for Winning Math Team BA");
			int winner = scan.nextInt();

			System.out.println("Insert a number");
			int x = scan.nextInt();
			System.out.println("Insert A");
			int a = scan.nextInt();
			System.out.println("Insert B");
			int b = scan.nextInt();
			MathTeam math = null;
			if (winner == 1) {
				math = new WinningMathTeamAB(x, a, b);
			} else if (winner == 2) {
				math = new WinningMathTeamBA(x, a, b);
			}
			Serialization.serialize(math);
		} else if (menu1 == 3) {
			System.out.println(Serialization.deserialize().likesCupcakes());
		} else if (menu1 == 4) {
			System.out.println("Select from the menu:");
			System.out.println("1 add");
			System.out.println("2 subtract");
			System.out.println("3 multiplication");
			System.out.println("4 division");
			int winner = scan.nextInt();
			MathTeam m = Serialization.deserialize();
			switch (winner) {
			case 1:
				m.add();
				break;
			case 2:
				try {
					m.subtract();
				} catch (Exception e) {
					System.out.println(m.returnString());
					System.out.println("Result is zero");
				}
				break;
			case 3:
				m.multiply();
				break;
			case 4:
				m.divide();
				break;
			}
			Serialization.serialize(m);
		}
	}

}
