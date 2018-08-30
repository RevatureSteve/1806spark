package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.bean.Car;
import com.revature.bean.Engine;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Testing Spring DI");

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastCar");
		Engine e = new Engine();
		
		System.out.println("Car: " + c);
		System.out.println("Engine: " + e);
	}

}
