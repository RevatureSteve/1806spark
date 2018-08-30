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
		 * 	IQ: Several ways to instantiate the Spring Bean Container
		 * 			ClassPathXmlApplicationContext - project's classpath
		 * 			FileSystemXmlApplicationContext - found somewhere on the device
		 * 			XmlWebApplicationContext - pulled via web
		 * 
		 * 	Create a Manager pojo
		 * 				managerService
		 * 				managerDao
		 * 				managerDaoImpl
		 * 					-2 methods: get manager from service
		 * 		Have both autowiring & beanwiring options
		 */
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastCar");
		System.out.println("Car: " + c);
		
		EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
		Employee emp = eService.getEmployeeById(55);
		
		System.out.println("Employee: " + emp);
		
		ManagerService mService = (ManagerService) ac.getBean("managerService");
		Manager mng = mService.getManagerById(30);
		
		System.out.println("Manager: " + mng);
	}

}
