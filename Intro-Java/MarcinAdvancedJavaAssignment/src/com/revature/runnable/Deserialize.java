package com.revature.runnable;

import com.revature.Serialization;
import com.revature.abstracts.MathTeam;

public class Deserialize implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		MathTeam math = Serialization.deserialize();
		System.out.println(math);
		
		
	}

}
