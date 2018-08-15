//package com.revature;
//
//import com.revature.dao.UserDao;
//import com.revature.dao.UserDaoImpl;
//import com.revature.domain.User;
//import com.revature.service.AppService;
//
//public class Driver {
///*
// * finally, using a maven project!
// *  maven project give us a pom.xml
// *  
// *  what is pom.xml file?
// *      POM stand for: project object model
// *  	the pom file hold meta data of the project
// *  		- name of the project
// *  		- external libraries (aka jar) (dependency)
// *  		- package type e.g jar or war
// *  		- Version number ...# of project 0.0.1-snapshot
// *  		-  version of java using 
// *  
// *   remember that html, xml, are not programming languages 
// *      they are just common formats that are machine and human readable
// *      
// *      ****NOTE DO IT EVERY TIME :
// *      ** if you change the pom.xml in eclipse/sts
// *      you to right click on --> MAVEN --> project --> update project
// *      
// *      the pom.xml file replaces the .classpath which is a binary version of pom.xml file
// *      
// *      SO WHAT IS MAVEN?
// *        a build tool (to build artifacts: jar or war)
// *        a dependency manager ( jar manager)
// */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("testing out a maven project");
//		//start with implemennting sone of the use cases
//		// maybe start with login- what is needed? ( hard coded)
//				// 	COMPARE userNameInput w/ usernameDB
//				//	compare pwInput with pwDB
//		//UserDoa
//			//getUsername /pw
//		// pojo:
//			//user: uId, username, pw
//			// task: tid, uId, tName, tsLevel 
//		
//		
//		String usernameInput ="";
//		String pwInput  = "";
//		
//		
//	User validUser =	new AppService().login(new User(0, usernameInput, pwInput));
//			System.out.println("is the user valid: " + validUser);
//		
//		
//	}
//
//}
