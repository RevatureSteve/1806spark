package com.revature.proxyapp;

import org.springframework.stereotype.Component;

@Component("appProxy")
public class MyAppProxy {
	public int drawCartoon() {
//		System.out.println("--- start the tracks ---");
//		System.out.println("--- vibe these beats ---");
		System.out.println("--- drawing a cartoon ---");
		return 3;
	}
	
		public int drawCartoon(int i) {
//		System.out.println("--- start the tracks ---");
//		System.out.println("--- vibe these beats ---");
			System.out.println("--- drawing a cartoon ---");
			return i;
		}
	
	
	public void drawNature() {
//		System.out.println("--- start the tracks ---");
//		System.out.println("--- vibe these beats ---");
		System.out.println("--- drawing some trees ---");

	}
	
	
	public void sculptPottery() {
//		System.out.println("--- start the tracks ---");
//		System.out.println("--- vibe these beats ---");
		System.out.println("--- sculpt a pot ---");

	}
	
	
	
}
