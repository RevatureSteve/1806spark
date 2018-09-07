package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.proxyapp.MyAppProxy;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext appCon = new ClassPathXmlApplicationContext("bean.xml");
		
		MyAppProxy appProx = appCon.getBean("appProxy", MyAppProxy.class);
		
		appProx.drawCartoon();
		appProx.drawCartoon(15);
		appProx.drawNature();
		appProx.sculptPottery();
	}

}
