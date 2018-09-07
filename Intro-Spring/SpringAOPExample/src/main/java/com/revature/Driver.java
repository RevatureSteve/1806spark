package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.AppService;

public class Driver {

	/*
	 *  AOP - Not specific to Spring, spring just uses it too
	 *  
	 *  	Aspect Oriented Programming
	 *  
	 *   "Highjack" methods to build a module with it (aspect)
	 *   	Aspect is the module you are building like:
	 *   		-logging module
	 *   		-transactions module
	 *   		-security module
	 *   		(bread crumb system)
	 *   
	 *   Aspect -Class used for an AOP feature
	 *   Advice -types of interceptions
	 *   PointCut -The expression of the methods you want to intercept
	 *   JoinPoint - a point in the code that can be intercepted
	 *   				e.g. method/exception thrown
	 *   
	 *   https://blog.espenberntsen.net/2010/03/20/aspectj-cheat-sheet/
	 */
	public static void main(String[] args) {
		System.out.println("spring aop");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		AppService app = (AppService) ac.getBean("appService");
		
		app.playComedyShow();
		app.playConcert();
		app.runAmusementPark();
	}
	
}
