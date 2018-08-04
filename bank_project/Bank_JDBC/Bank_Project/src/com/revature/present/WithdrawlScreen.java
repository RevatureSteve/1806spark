package com.revature.present;

import com.revature.interfaces.Screen;

public class WithdrawlScreen implements Screen{

	@Override
	public Screen start() {
		System.out.println("Withdrawl");
		return new MainMenuScreen().start();
	}

}
