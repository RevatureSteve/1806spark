package com.revature;

import cam.revature.domain.User;
import cam.revature.service.AppService;

public class Driver {
	
	/*
	 * Finally using a Maven Project!
	 * Maven projects give us a pom.xml
	 * 
	 * What is a pom.xml?
	 * POM: project object model
	 * this file holds the meta data of the project
	 * -name of the project
	 * -external libraries (dependencies) aka JARS
	 * -PACKAGE type E.G. JAR OR WAR
	 * -version number o the project 0.0.1-SPAPSHOT
	 * -version of java using
	 * 
	 * 
	 * Remember the XML, JSON, HTML are not programming languages
	 * 		They are common formats that are machine and human readable
	 * 
	 * 
	 * *NOTE: if you change the pom.xml in Eclipse/STS
	 * you need to right-click on project -> maven -> update project*
	 * 
	 * the pom.xml replaces the .classpath with is a binary version of the pom.xml file
	 * 
	 * So what is Maven?
	 * a build tool
	 * a dependency manager(jar manager)
	 */

	public static void main(String[] args) {
			System.out.println("testing a maven project");
		// start implementing some of the use cases
			//start with login
			//Service class for: compare usernameInput/pw with db
			//UserDao: get username and pass
			//POJO: User: id, username, pw
			//		Task: tid, uid, tname, tsid, tslevel
			
			String usernameInput = "Steve";
			String pwInput = "123";
			
			User validUser = new AppService().login(new User(0,usernameInput, pwInput));
			System.out.println("Is the user valid: " + validUser);
	}

}
