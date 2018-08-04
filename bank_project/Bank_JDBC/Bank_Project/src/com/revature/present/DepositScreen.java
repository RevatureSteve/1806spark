package com.revature.present;

import com.revature.interfaces.Screen;

public class DepositScreen implements Screen{

	@Override
	public Screen start() {
		System.out.println("Deposit");
		return new MainMenuScreen().start();
	}

}
