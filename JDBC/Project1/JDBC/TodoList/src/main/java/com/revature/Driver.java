/*package com.revature;

import com.revature.domain.User;
import com.revature.service.AppService;

public class Driver {

	
	 * finally using a MAven Project!
	 * 		Maven projects give us a pom.xml
	 * 
	 * What is a pom.xml file?
	 * 		pom: porject object model
	 * 		the pom file hold the meta data of the project
	 * 			- name of the project
	 * 			- external libraries aka JARS (dependencies) 
	 * 			- package type e.g. jar or war
	 * 			- version # of the project 0.0.1-SNAPSHOT
	 * 			- version # of java 
	 * 
	 * remember that XML, JSON, HTML are not programming languages
	 * 		they are common formats that are a machine and human readable
	 * 
	 * 		*note: if you change the pom.xml in Eclipse/STS
	 * 			you need to right click on project -> mave -> update project
	 * 
	 * 		the pom.xml file replaces the .classpath which is a binary version of the pom.xml file
	 * 
	 * So what actually is Maven?
	 * 		a build tool (to build artifacts: jar or war)
	 * 		a dependency manager (jar manager)
	 
	public static void main(String[] args) {
		System.out.println("testing...");
		//start implementing some of the use cases 
		//maybe start w/ login - what's needed?
		//		login()
		//		compare usernameInput w/ usernameDb
		//		compare pwInput w/ pwDb
		
		// UserDao
		//		get Username/pw
		
		//	POJO
		//		user: uId, username, pw
		//		task: tId, uId, tName, tsId, tsLevel  
		
		
		String usernameInput = "steve";
		String pwInput = "123";
		
		User validUser = new AppService().login(new User(0, usernameInput, pwInput));
		System.out.println("is the user valid: " + validUser);
		//UserDao userDao = new UserDaoImpl().getUserByUsername(usernameInput); cannot do method chaining
		
	}
	

}*/
