package com.revature.presentation;

import java.util.Scanner;

import com.revature.Screen;

public class MainMenuScreen implements Screen {

	@SuppressWarnings("resource")
	@Override
	public Screen Start() {
		Scanner scan = new Scanner(System.in); 
	System.out.println("ROBO INDUSTRIES (TM) TERMALINK PROTOCOL\n"
			+ "ENTER 1 TO LOGIN");
	System.out.println("ENTER 2 TO EXIT\n");
	System.out.println("4 ATTEMPT(S) LEFT: [] [] [] [] \n");
	
	System.out.println("0 x 8 7 F A  , + ( ; ; . - $ % .     0 x 1 F 0 A  { % * # * , % } * _ ");
	System.out.println("0 x 3 9 E 7    0 x 6 B D 1 ");
	System.out.println("0 x 7 A 7 8    0 x 3 B 7 2 ");
	System.out.println("0 x 4 E 7 3    0 x 6 D 6 1 ");
	System.out.println("0 x 3 1 D F    0 x 5 C C 2 ");
	System.out.println("0 x 4 F E 2    0 x 5 2 F 5 \n");
	
	int input = scan.nextInt();
	
	
	switch (input) {
	case 1:
		return new LoginScreen();
	case 3:
		//return new RegisterScreen();
	case 2:
		System.out.println("LOGGED OUT");
		System.exit(1);
		break;

	default:
		break;
	}
	return this;
	}
}
