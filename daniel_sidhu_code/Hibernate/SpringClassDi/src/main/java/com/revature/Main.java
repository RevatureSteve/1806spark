package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.domain.Car;
import com.revature.domain.Employee;
import com.revature.domain.Manager;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

public class Main {

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
	 *  	Autowiring w/ annotations (@)
	 *  	steps:
	 *  		1.In spring bean configuration file
	 *  		spring context - turn on base component scan
	 *  		provide the base-package e.g com.revature
	 *  		
	 *  		2.Beanify your classes you want with !s or still
	 *  			XML but lets use @s for this
	 *  
	 *  	Spring @s
	 *  		@Component - most simple Spring @; marks a class as spring bean
	 *  		@Service - business logic class annotation
	 *  		@Repository - will be used in Spring ORM/Data for dao interfaces/impls
	 *  		@Autowired - DI another Spring Bean
	 *  
	 */
	public static void main(String[] args) {
		System.out.println("Spring DI");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c =  (Car) ac.getBean("fastCar");
		System.out.println("my car: " + c);
		
		EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
		ManagerService mService = (ManagerService) ac.getBean("managerService");
		
		Employee emp = eService.getEmployeesById(55);
		Manager mgr = mService.getManagerById(23);
		
		System.out.println("Employee: " + emp);
		System.out.println("Employee: " + mgr);
	}
}
