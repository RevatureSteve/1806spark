package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.FlashCard;
import com.revature.service.FcService;

public class MainClass {

	/*
	 * 	Welcome to Spring ORM
	 * 	-Integration of an ORM Framework with Spring, we'll use Hibernate
	 *	-Allows us to use an ORM framework easier (less to manage)
	 */
	public static void main(String[] args) {
		System.out.println("Spring ORM!");
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		FcService fcService = (FcService) ac.getBean("fcService");
		fcService.createFlashCard(new FlashCard(1, "what is java?", "coffee"));
		System.out.println(fcService.getAllFlashCard());		
	}

}
