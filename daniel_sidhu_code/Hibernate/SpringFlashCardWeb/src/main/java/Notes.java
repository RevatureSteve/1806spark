
public class Notes {
	
	/*
	 * 	Spring MVC Notes:
	 * 		First note: Spring MVC was built originally 
	 * 			with template engines in mind
	 * 		Template Engines aka html engines
	 * 			Used for Server-side Rendering
	 * 		Examples of Template Engines: JSP, Groovy, Thymeleaf, FreeMarker
	 * 		We need to know both - Rest vs Server-side Rendering Diagrams!
	 * 
	 * 		FrontController DesignPattern - One servlet handling All: 
	 * 			requests: 
	 * 		Once an HttpRequest hits the Spring Servleet
	 * 			The servlet forwards the request to the appropriate Controller
	 * 
	 * 	Spring MVC @s: @Controller, @RestController
	 * 
	 * 	Spring MVC Setup (non-boot): 
	 * 		0. create spring bean configuration file WEB-INF
	 * 		1. (beans.xml)turn on contect-component scan
	 * 		2. (beans.xml)turn on MVC scan
	 * 		3. (web.xml) map the one and only servlet with request to it
	 */
}
