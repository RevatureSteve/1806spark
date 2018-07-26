package com.console.drake;

public class ExitScreen implements Screen {
	
	@Override
	public Screen start() {
		
		System.out.println("thanks for visiting!");
		MyLauncher.exit = true;
		return null;
		
	}

}
