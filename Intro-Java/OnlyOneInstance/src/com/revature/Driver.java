package com.revature;

import com.revature.pojo.Hercules;

public class Driver {

	/*
	 * Singleton is a type of design pattern
	 * 		Goal is to restrict instantiation to only 1
	 * Design patter: common solution to a problem
	 */
	public static void main(String[] args) {
		System.out.println("test");
		
		System.out.println(Hercules.getHercules().getName());
	}

}
