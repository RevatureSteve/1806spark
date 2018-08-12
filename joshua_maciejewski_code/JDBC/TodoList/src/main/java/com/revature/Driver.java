package com.revature;

import com.revature.Dao.UserDao;
import com.revature.Dao.UserDaoImpl;
import com.revature.domain.User;
import com.revature.service.AppService;

public class Driver {

	/*
	 * Finally using a maven project!
	 * 	maven projects give us a pom.xml
	 * 
	 * What is a pom.xml file?
	 * 		pom: project object model
	 * 		the pom file holds the meta data of the project 
	 * 			- name
	 * 			- external libraries aka JARS (dependencies)
	 * 			- package type e.g. jar or war
	 * 			- version # 0.0.1 - SNAPSHOT
	 * 			- version of Java using 
	 * 
	 * remember that XML, JSON, HTML are not programming languages, 
	 * 		They are common formats that are machine and human readable 
	 * 
	 * 
	 * 		*NOTE: when you change the pom.xml in Eclipse/STS
	 * 			you need right-click on project -> maven -> update project
	 * 
	 * 
	 * 		the pom.xml file replaces the .class path which is a binary version of the pom.xml file
	 * 
	 * 
	 * so what actually is maven?
	 * 		 a build tool (to build artifacts: jar or war)
	 * 		 a dependency manager (jar manager)
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("testing a maven project");
		//start implementing some of the use cases
		//maybe start with login- what's needed? (hardcoded)
		// service class for:
		// 		compare usernameInput w/ usernameDb
		//		compare pwInput w/ pwDb
		// userDao
			//get Username/pw
		//POJO
			//user: uId, username, pw
			//task: tId, uId, tName, tsID, tsLevel
		
		
		String usernameInput = "steve";
		String pwInput = "";
		
		
		
		//cannot do... method chaining is returning a user object not a user dao object
		//UserDao userDao = new UserDaoImpl().getUserByUsername(usernameInput);
		
		UserDao userDao = new UserDaoImpl();
		User user = new UserDaoImpl().getUserByUsername(usernameInput);
		System.out.println(new UserDaoImpl().getUserByUsername(usernameInput));
		
		//same as: System.out.println("user")
		
		
		
		User validUser = new AppService().login(new User(0,usernameInput,pwInput));
			System.out.println("Is the user valid:" + validUser);
		
		
		
		
		
	}

}
