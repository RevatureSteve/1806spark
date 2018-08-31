package com.revature.SpringBootExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {
/*
 * 	Spring Boot:
 * 		no longer using xml files for configuration
 * 		Replacing beans.xml with application.properties/.yml
 * 			by default:
 * 				 context:component-scan on
 * 				 mvc annotation driven on
 * 				 tx/jpa(data) on
 * 				 aop is on
 * 
 * 		Actuator Dependency: provide documents and health endpoints
 * 			e.g. /health, /bean, /info
 * 		
 * 		Devtools Dependency: automatic restart when there is a change to the code (like angular)
 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}
}
