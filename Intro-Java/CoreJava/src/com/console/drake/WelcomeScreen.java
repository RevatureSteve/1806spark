package com.console.drake;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WelcomeScreen implements Screen {
	
	// maybe use the Console class, return by the Console method from the System class
	// for a bufferedreader, wrapping an InputStream System.in with a Reader InputStreamReader to be wrapped by BufferedReader
	private BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public Screen start() {
		
		System.out.println("Welcome to the program!");
		System.out.println();
		System.out.println("Press any key to continue");
		
		// need try/catch or throws declaration for buff.read()
//		buff.read();
			
		return new MainMenuScreen();
	}

}
