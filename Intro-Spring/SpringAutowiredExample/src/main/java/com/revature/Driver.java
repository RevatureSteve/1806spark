package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.EmpService;

public class Driver {
	/*
	 * Spring Autowired Example
	 * 	
	 * 	How do I create/instantiate the Spring Bean Container?
	 * 		Use one of the ApplicationContext paths
	 * 				on internet-XmlWebApplicationContext
	 * 				on computer-FileSystemXmlApplicationContext
	 * 				part of project-ClassPathXmlApplicationContext
	 * 		1. Mark each class that you want managed by the Spring Bean Container
	 * 			with the appropriate Annotation @
	 * 		2. Add Context namespace to beans.xml
	 * 		3. Use context component-scan to allow for searching of the @s
	 *  	4. Use @Autowired where needed
	 */
	public static void main(String[] args) {
		System.out.println("hello spring");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		EmpService service = (EmpService) ac.getBean("employeeService"); 
		System.out.println("Returned from Service: " + service.getEmployee());
	}

}
