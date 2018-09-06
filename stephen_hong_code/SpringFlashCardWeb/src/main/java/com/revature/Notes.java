package com.revature;

public class Notes {
	
	/*
	 * 	Spring MVC Notes:
	 * 		Spring MVC is an implementation of MVC design pattern
	 * 		1. Spring MVC was built originally with template engines in mind
	 * 			Template Engines aka html engines used for Server-side rendering
	 * 		Examples of Template Engines: JSP, Groovy, Thymeleaf, FreeMarker
	 * 		need to know both Rest vs Server-side rendering diagrams
	 * 		
	 * 		FrontController DesignPattern (Dispatcher Servlet) - One servlet handling All requests:
	 * 		Once an HttpRequest hits the Spring Servlet
	 * 			THE servlet forwards the request to the appropriate controller
	 * 
	 * 	Spring MVC @s: @Controller, @RestController, @RequestMappers("/home")
	 * 
	 * 	Spring MVC Setup (non-boot):
	 * 		0. create spring bean configuration file in WEB-INF
	 * 		1. (beans.xml)turn on context component scan
	 * 		2. (beans.xml)turn on mvc scan
	 * 		3. (web.xml) map the one and only servlet with requests to it
	 * 
	 * 	View Resolver: use prefix & suffix to shorten file path
	 * 		instead of /a/b/c/d/e/f/one.html,
	 * 			prefix("/a/b/c/d/e/f/")
	 * 			suffix(".html")
	 * 			and call for "one"
	 */

}
