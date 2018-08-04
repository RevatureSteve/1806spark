package com.project.singleton;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Singleton variableName = Singleton.getInsatnce(); // this wioll work bc it will give you an instance and use . to get more result
//		Singleton.getWon(); this wil not work because getwon is a differet scope 
		variableName.getWon();
		System.out.println(variableName.toString());

	}

}
