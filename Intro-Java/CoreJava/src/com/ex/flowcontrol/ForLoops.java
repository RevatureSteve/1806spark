package com.ex.flowcontrol;

public class ForLoops {
	public static void main(String[] args) {

		/*
		 * In a for loop there are 3 sections (all are optional)
		 * 
		 * for( define vars ; condition ; assignment ){}
		 */

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

		//Infinite loop
		for (;;) {
			System.out.println("forever");
		}

	}
}
