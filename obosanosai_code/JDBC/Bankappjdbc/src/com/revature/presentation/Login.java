package com.revature.presentation;

import java.util.Scanner;

import com.revature.interfaces.Screen;
import com.revature.services.Service;

public class Login implements Screen {

	@Override
	public Screen start() {
		Scanner scan = new Scanner(System.in);
		        System.out.println(    
		        		
		        		"                                   ███████▀░░░░░░░░░░░░░░░▀███████\n       " + 
		        		"                            █████▀░░██▌░░░░░░░░░▐██░░▀█████\n          " + 
		        		"                         ████▀░██████░░░░░░░██████░▀████\n          " + 
		        		"                         ███▀░████████░░░░░████████░▀███\n          " + 
		        		"                         ██░░██████████░░░██████████░░██\n          " + 
		        		"                         ██░███████████▌░▐███████████░▐█\n          " + 
		        		"                         █▌▐█████──▀███▌░▐███▀──█████▌▐█\n          " + 
		        		"                         █▌▐█████▄──▐██░░░██───▄█████▌▐█\n          " + 
		        		"                         █▌░██████████░░░░░██████████░▐█\n          " + 
		        		"                         █▌░░████████░░░░░░░████████░░▐█\n          " + 
		        		"                         █▌░░░░█████░░░░░░░░░█████░░░░▐█\n          " + 
		        		"\n" + 
		        		"");
		
		System.out.println("                            +++++++++++++++++++++++++++++++++++++++++            ");
		System.out.println("                                 𝓓𝓔𝓐𝓓𝓟𝓞𝓞𝓛 𝓤𝓝𝓘𝓥𝓔𝓡𝓢𝓐𝓛 𝓑𝓐𝓝𝓚                    ");
		System.out.println("                            +++++++++++++++++++++++++++++++++++++++++            ");
		System.out.println("                                 Steal everything stealable...                    ");
		System.out.println("                            ");
		System.out.println("Enter your Secret Identity: ");
		System.out.println("                            ");
		String userName = scan.nextLine();
		System.out.println("                        ");
		System.out.println("Enter your Secret Code: ");
		System.out.println("                        ");
		String password = scan.nextLine();
		
		if (Service.userExists(userName, password)) {
			return new MainMenu().start();
		}
		System.out.println("                                                                              ");
		System.out.println("Ha! Green Lantern i know that's you, Thanos sent you, didn't he?.              ");
		System.out.println("                                                                              ");
		return this.start();
	}

}