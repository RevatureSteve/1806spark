package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	
public static void main(String[] args) {
		System.out.println("testing spring DI");
		/*
		 * Several ways to instantiate the Spring Bean Container
		 * 	ClassPathXmlApplicationContext - project's classpath
		 * 	FileSystemXmlApplicationContext
		 * 	XMLWebApplicationContext - pulled via web
		 */
	
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastCar");
	
		Engine e = new Engine();
	
		System.out.println("Car:" + c);
		System.out.println("Engine" + e);
}
	
}

