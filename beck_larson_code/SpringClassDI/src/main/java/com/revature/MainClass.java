package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.model.Engine;
import com.revature.model.Manager;
import com.revature.services.EmployeeService;
import com.revature.services.ManagerService;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Testing Spring DI");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastCar");
		
		Engine e = new Engine();
		
		System.out.println("Car: " + c);
		
		EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
		
		Employee emp = eService.geEmployeeById(55);
		
		System.out.println("Employee: " + emp);
		
		ManagerService mgr = (ManagerService) ac.getBean("managerService");
		Manager mana = mgr.geManagerById(221);
		
		System.out.println("Manager: " + mana);
	}

}
