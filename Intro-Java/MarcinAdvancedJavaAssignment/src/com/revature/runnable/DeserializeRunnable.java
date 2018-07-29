package com.revature.runnable;

import com.revature.Serialization;
import com.revature.abstracts.MathTeam;

public class DeserializeRunnable implements Runnable {

	@Override
	public void run() {
		MathTeam math = Serialization.deserialize();
		System.out.println(math);
	}
}
