package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.model.Engine;
import com.revature.service.EmployeeService;

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
		 */
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastCar");
		System.out.println("Car: " + c);
		
		
		EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
		Employee emp = eService.getEmployeeById(55);
		
		System.out.println("Employee: " + emp);
	}

}
