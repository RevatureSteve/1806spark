package com.ex.store;

public class Main {

	public static void main(String[] args) {
		Screen s = new MainMenuScreen();
		while (true) {
			s=s.start();
		}
	}
	public Main() {
	}

}
