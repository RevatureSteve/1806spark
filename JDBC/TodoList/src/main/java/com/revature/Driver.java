<<<<<<< HEAD
//package com.revature;
//
//import javax.servlet.http.HttpServlet;
//
//import com.revature.domain.User;
//import com.revature.service.AppService;
//
//public class Driver {
//
//	/*
//	 *  Finally using a Maven Project!
//	 *  	Maven projects give us a pom.xml
//	 *  
//	 *  What is a pom.xml file?
//	 *  	pom: project object model
//	 *  	The pom file holds the meta data of the project
//	 *  		- name of the project
//	 *  		- external libraries aka JARS (dependencies)
//	 *  		- package type e.g. jar or war
//	 *  		- version # of the project 0.0.1-SNAPSHOT
//	 *  		- version of java using
//	 *  
//	 *  Remember that XML, JSON, HTML are not programming languages
//	 *  	They are common formats that are machine and human readable 
//	 *  
//	 *  	*NOTE: if you change the pom.xml in Eclipse/STS
//	 *  		you need right-click on project -> maven -> update project *
//	 *  
//	 *  	the pom.xml file replaces the .classpath 
//	 *  		which is a binary version of the pom.xml file
//	 *  
//	 *  So what actually is Maven?
//	 *  	a build tool (to build artifacts: jar or war)
//	 *  	a dependency manager (jar manager)
//	 */
//	public static void main(String[] args) {
//		System.out.println("testing a maven project");
//		// start implementing some of the use cases
//		// maybe start with login- what's needed? (hardcoded)
//		// 	Service class for:
//		//		login()
////				compare usernameInput w/ usernameDb
//		//  	compare pwInput w/ pwDb
//		//  UserDao
////				get Username/pw 
////			Done -POJO:
////				User: uId, username, pw
////				Task: tId, uId, tName, tsLevelID, tsLevel 
//		
//		
//		String usernameInput = "steve";
//		String pwInput = "123";
//		
//		User validUser = new AppService().login(new User(0,usernameInput,pwInput));
//		System.out.println("Is the user valid: " + validUser);
//		
//	}
//
//}
=======
package com.revature;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;
import com.revature.service.AppService;

public class Driver {

	/*
	 * 	Maven projects give us pom.xml
	 * 		pom: project object model
	 * 		The pom file holds the meta data of the project
	 * 			- name of the project
	 * 			- external libraries aka jars (dependencies)
	 * 			- package type e.g. jar or war
	 * 			- version # of the project 0.0.1-SNAPSHOT
	 * 			- version of Java
	 * 
	 * 	XML, JSON, HTML are common formats that are machine and human readable
	 * 
	 * 	If you change the pom.xml in Eclipse/STS
	 * 		you need to right-click on Project -> Maven -> Update Project (Alt + F5)
	 * 
	 * 	the pom.xml file replaces the .classpath
	 * 		which is a binary version of the pom.xml file
	 * 
	 * 	Maven is:
	 * 		- a build tool (to build artifacts: jar or war)
	 * 		- a dependency manager (jar manager)
	 */
	public static void main(String[] args) {
		System.out.println("TEST");
		//	start implementing some of the use cases
		//	start with login
		//	Service class for:
		//		compare usrnameInput w/ usernameDb
		//		compare pwInput w/ pwDb
		//	UserDao
		//		get Username/pw
		//	POJO
		//		User: id, username, pw
		//		Task: 
		
		String usernameInput = "Steve";
		String pwInput = "123";
		
		User validUser = new AppService().login(new User(0, usernameInput, pwInput));
		System.out.println("Is the user valid: " + validUser);
		
		//	UserDao userDao = new UserDaoImpl().getUserByUsername(usernameInput);
		//	cannot do...method chaining is returning a User object not a UserDao object
		
//		User user = new UserDaoImpl().getUserByUsername(usernameInput);
//		System.out.println(user);
	}

}
>>>>>>> 4eb29dca203a33cdc98ed607180e8dc41eace9bf
