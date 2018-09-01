package com.revature.service;

import org.springframework.stereotype.Component;

@Component("appService")
public class AppService {

	public void playComedyShow() {
		System.out.println("---------------");
		System.out.println("Comedy Show Plays!");
		System.out.println("---------------");
	}

	public void playConcert() {

		System.out.println("---------------");
		System.out.println("Concert Plays");
		System.out.println("---------------");
	}

	public void runAmusementPark() {
		System.out.println("---------------");
		System.out.println("Ausement park runs");
		System.out.println("---------------");
	}
}
