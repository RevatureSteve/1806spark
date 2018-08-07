package com.revature;

public class Driver {
	
	/*
	 * Finally using a Maven Project
	 * 		Maven projects give us a pom.xml
	 * 
	 * What is a pom.xml file?
	 * 		pom: project object model
	 * 		The pom file holds the meta data of the project.
	 * 			-name of the project
	 * 			-external libraries aka JARS(dependencies)
	 * 			-package type e.g. jar or war
	 * 			-version # of the project 0.0.1-SNAPSHOT
	 * 			-version of Java using
	 * 
	 * Remember that XML, JSON, and HTML are not programming languages
	 * 		They are common formats that are machine and human readable
	 * 
	 * 		*NOTE: if you change the pom.xml file in Eclipse/STS
	 * 			you need to right click on project -> maven -> update project*
	 * 
	 * 		the pom.xml files replaces the .classpath 
	 * 			which is a binary version of the pom.xml file
	 * 
	 * So what actually is Maven?
	 * 		-a build tool (to build artifacts: jar or war)
	 * 		-a dependency manager (jar manager)
	 */
	public static void main(String[] args) {
		System.out.println("testing a maven project");

	}

}
