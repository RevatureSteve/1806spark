package com.example.proxyapp;

import org.springframework.stereotype.Component;

@Component("appProxy")
public class MyAppProxy {
	public int drawCartoon() {
//		System.out.println("--- start the fire tracks ---");
//		System.out.println("--- vibe these beats ---");
		System.out.println("--- drawing a cartoon ---");
		return 3;
	}
	
	public int drawCartoon(int i) {
		System.out.println("--- drawing a cartoon ---");
		return i;
	}
	
	public void drawNature() {
//		System.out.println("--- start the fire tracks ---");
//		System.out.println("--- vibe these beats ---");
		System.out.println("--- drawing nature ---");
	}
	
	public void sculptPottery() {
//		System.out.println("--- start the fire tracks ---");
//		System.out.println("--- vibe these beats ---");
		System.out.println("--- sculpting pottery ---");
	}

}
