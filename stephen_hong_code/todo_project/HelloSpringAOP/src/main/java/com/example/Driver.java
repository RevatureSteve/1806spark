package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.proxyapp.MyAppProxy;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("monkey.xml");
		
		MyAppProxy approx = appCon.getBean("appProxy", MyAppProxy.class);
		
		approx.drawCartoon();
		approx.drawCartoon(15);
		approx.drawNature();
		approx.sculptPottery();
	}

}
