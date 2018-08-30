package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.model.Manager;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Testing Spring DI");
		/*
		 * 		IQ
		 *  Several ways to instantiate the Spring Bean Container
		 *  	ClassPathXmlApplicationContext - project's classpath
		 *  	FileSystemXmlApplicationContext - found somewhere on the device
		 *  	XmlWebApplicationContext - pulled via web
		 *  
		 *  Create an Manager Pojo
		 *  		  ManagerService
		 *  		  ManagerDao
		 *  		  ManagerDaoImpl
		 *  			-2 methods
		 *  	get a Manager from ManagerService
		 *  	
		 *  	Have both autowiring / beanwiring options 
		 *  
		 *      Autowiring with @s
		 *      Steps:
		 *         1. In spring bean configuration file
		 *         spring contect - Turn on base component scan
		 *         provide the base-package e.g. com.revature
		 *         2. Beanify your classes you want @s or still
		 *              XML but lets use @s for this
		 *         3. Use @Autowired for DI of other Spring Beans
		 *            e.g.
		 *               ManagerService has Autowired ManagerDaoImpl
		 *              
		 *      Spring @s
		 *           @Component - most simple Spring @; marks a class as a spirng bean
		 *           @Service - business logic class annotation
		 *           @Repository - will be used in Spring ORM/DATA for dao interfaces/impls
		 *           @Autowired - DI another Spring Bean
		 *  
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastCar");
		System.out.println("Car: " + c);
		
		
		EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
		Employee emp = eService.getEmployeeById(55);
		
		System.out.println("Employee: " + emp);
		
	    ManagerService mService = (ManagerService) ac.getBean("managerService");
		Manager mgr = mService.getManagerById(33);
		
		System.out.println("Manager: " + mgr);
	}

}