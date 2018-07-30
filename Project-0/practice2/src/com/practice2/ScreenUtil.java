package com.practice2;

public class ScreenUtil implements Convertible {

	public void welcomeScreen() {
		System.out.println();
		this.welcomeMessage();
	}

	@Override
	public boolean isConvertible() {
		
		return true;
	}
	
}
