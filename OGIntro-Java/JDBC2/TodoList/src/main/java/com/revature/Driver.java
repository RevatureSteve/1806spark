package com.revature;

import com.revature.dao.UserDaoImpl;

public class Driver {
	
	/*
	 * Finally using a Maven Project!
	 * 		Maven projects give us a pom.xml
	 * 
	 * What is a pom.xml file?
	 * 		pom: project object model
	 * 		The pom file holds the meta data of the project
	 * 			- name of the project
	 * 			- external libraries aka JARS (dependencies)
	 * 			- package type e.g. jar or war
	 * 			- version # 0.0.1 - SNAPSHOT
	 * 			- version of java using
	 * 
	 * Remember that XML, JSON, HTML are not programming languages
	 * 		They are common formats that are machine and human readable
	 * 
	 * 		*NOTE: if you change the pom.xml in Eclipse/STS
	 * 			you need to right-click on project -> maven -> update project *
	 * 
	 * 		the pom.xml file replaces the .classpath 
	 * 			which is a binary version of the pom.xml file
	 * 
	 * So what actually is Maven?
	 * 		a build tool (to build artifacts: jar or war)
	 * 		a dependency manager (jar manager)
	 */

	public static void main(String[] args) {
		System.out.println("testing a maven project");
		// start implementing some of the use cases
		// maybe start with login - what's needed? (hardcoded)
		//		login()
		//		compare usernameInput w/username Db
		// 		compare pwInput w/ pwDb
		//	UserDao
		//		get Username/pw
		//	POJO:
		//		User:id, username, pw
		//		Task: tId, uId, tName, tsId, tsLevel
		
		String usernameInput = "steve";
		String pwInput = "";

	
		
		System.out.println(new UserDaoImpl().getUserByUsername(usernameInput));
		//cannot do!.. method chaining is returning a user Object not a userDao object
		//UserDao userdao= new UserDaoImpl().getByUsername(usernameInput);
	}

}
