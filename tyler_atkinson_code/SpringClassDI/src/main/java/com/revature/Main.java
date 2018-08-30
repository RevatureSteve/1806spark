package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Car;
import com.revature.model.Employee;
import com.revature.model.Engine;
import com.revature.service.EmployeeService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello Tyler, Have a great day!");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Car c = (Car) ac.getBean("fastCar");
				
		Engine e = new Engine();
		
		System.out.println("CarL" + c);
		System.out.println("Engine" + e);
		
		EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
		Employee emp = eService.getEmployeeById(55);
		
		System.out.println("Employee " + emp);
	}

}
