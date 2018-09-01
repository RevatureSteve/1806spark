package com.ex.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ex.service.EmployeeService;

public class MainClass {
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-beans.xml");
		
		EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeServiceImpl");
		
		employeeService.authenticate();
		
		
	}
}
