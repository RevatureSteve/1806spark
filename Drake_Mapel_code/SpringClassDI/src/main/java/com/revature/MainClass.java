package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

public class MainClass {
	
	public static void main(String[] args) {
		System.out.println("Testing Spring DI");
		/*
		 * 	Several ways to instantiate the Spring Bean Container
		 * 		ClassPathXmlApplicationContext - project's classpath
		 * 		FileSystemXmlApplicationContext - found somewhere on the device
		 * 		XmlWebApplicationContext - pulled via web
		 * 
		 * 	Create a Manager POJO
		 * 			ManagerService
		 * 			ManagerDao
		 * 			ManagerDaoImpl
		 * 				- 2 methods
		 * 		get a Manager from ManagerService
		 * 
		 * 		Have both autowiring / beanwiring options
		 * 
		 * 		Autowiring w/ @s
		 * 		Steps:
		 * 				1.	In spring bean configuration file
		 * 				spring context - Turn on base component scan
		 * 				provide the base package e.g., com.revature
		 * 				2. beanify your classes you want w/ @s or still
		 * 					XML, but let's use @s for this
		 * 				3. Use @Autowired for DI of other Spring Beans
		 * 					e.g.
		 * 						ManagerService has Autowired ManagerDaoImpl
		 * 
		 * 		Spring @s
		 * 			@Component - simplest Spring @; marks a class as a Spring bean
		 * 			@Service - business logic class annotation
		 * 			@Repository - will be used in Spring ORM/Data for DAO impls
		 * 			@Autowired - DI another Spring Bean
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastcar");
		System.out.println("Car: " + c);
		
		
		EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
		Employee emp = eService.getEmployeeById(55);
		
		System.out.println("Employee: " + emp);
		
		ManagerService mService = (ManagerService) ac.getBean("managerService");
		Manager m
	}

}
