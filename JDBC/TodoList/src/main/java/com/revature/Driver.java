//package com.revature;
//
<<<<<<< HEAD
=======
//import javax.servlet.http.HttpServlet;
//
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
//import com.revature.domain.User;
//import com.revature.service.AppService;
//
//public class Driver {
//
//	/*
<<<<<<< HEAD
//	 * 	Finally using a Maven Project!
//	 * 		Maven projects give us a pom.xml
//	 * 
//	 * 	What is a pom.xml file?
//	 * 		pom: project object model
//	 * 		The pom file holds the meta data of the project
//	 * 			- name of the project
//	 * 			- external libraries aka JARS (dependencies) 
//	 * 			- package type e.g. jar or war
//	 * 			- version # of the project 0.0.1-SNAPSHOT
//	 * 			- version of java you're using
//	 * 
//	 * 	Remember that XML, JSON, HTML are not programming languages
//	 * 		They are common formats that are machine and human readable 
//	 * 
//	 * 		*NOTE: if you change the pom.xml(you're supposed to) in Eclipse/STS
//	 * 			you need to right-click on project -> maven -> update project*
//	 * 
//	 * 		the pom.xml file replaces the .classpath which is a binary version of the pom.xml file
//	 * 
//	 * So what actually is Maven?
//	 * 		a build tool (to build artifacts: jar or war)
//	 * 		a dependency manager (jar manager)
//	 * 
//	 */
//	public static void main(String[] args) {
//		System.out.println("testing a maven project");
//		
//		// Start implementing some of the use cases
//		// maybe start with login - what's needed? (hardcoded)
//		// Service class for:
//		//		login()
//		// 		compare usernameInput w/ usernameDb
//		// 		compare pwInput w/ pwDb
//		// UserDao
//		// 		get username/pw
//		// POJO:
//		//		User: uid, username, pw
//		//		Task: tid, uid, tName, tsID, tsLevel
=======
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
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
//		
//		String usernameInput = "steve";
//		String pwInput = "123";
//		
<<<<<<< HEAD
//		User validUser = new AppService().login(new User(0, usernameInput, pwInput));
=======
//		User validUser = new AppService().login(new User(0,usernameInput,pwInput));
>>>>>>> 8ff4b17dd674ea7826c6e1af98f02d7fae8acae8
//		System.out.println("Is the user valid: " + validUser);
//		
//	}
//
//}
