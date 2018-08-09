package com.revature;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;
import com.revature.service.AppService;

public class Driver {
	
	/*
	 * Finally using a Maven Project!
	 * 	Maven projects give us a pom.xml
	 * 
	 * What is a pom.xml file?
	 * 	pom: project object model
	 * 	The  pom file holds the meta data of the project
	 * 		-name of the project
	 * 		-external libraries aka JARS (dependencies)
	 * 		-package type e.g. jar or war
	 * 		-version # of the project 0.0.1-SNAPSHOT
	 * 		-version of java using
	 * 
	 * Remember that XML, JSON, HTML are not programming languages
	 * 	They are common formats that are machine and human readable
	 * 
	 * 	*NOTE: If you change the pom.xml in Eclipse/STS
	 * 		you need to right-click on project -> maven -> update project*
	 * 	
	 * 	the pom.xml file replaces the .classpath 
	 * 		which is a binary version of the pom.xml file
	 * 
	 * So what actually is Maven?
	 * 	a build tool(to build artifacts: jar or war)
	 * 	a dependency manager (jar manager)
	 */

	public static void main(String[] args) {
		System.out.println("testing a maven project");
		//start implementing some of the use cases
		//maybe start with login - what's needed? (hardcoded)
		//compare usernameInput w/ usernameDb
		//compare pwInput w? pwDB
		//Service class for:
		//	login()
		//	compare usernameInput w/ usernameDb
		//	compare pwInput w/ pwDb
		//UserDo
		//	get Username/pw
		//POJO:
		//	User: id, username, pw
		//	Task: tId, uId ,tName, tsLevelID, tsLevel
		
		String usernameInput = "steve";
		String pwInput = "123";
		
		User validUser = new AppService().login(new User(0,usernameInput,pwInput));
		System.out.println("Is the user valid: " + validUser);
		
		UserDao userDao = new UserDaoImpl();
		//UserDao userDao = new UserDaoImpl().getUserByUsername(usernameInput); 
		//cannot do!..method chaining is returning a User Object not a UserDao object
		System.out.println(new UserDaoImpl().getUserByUsername(usernameInput));
	}

}
