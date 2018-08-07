package com.revature;

public class Driver {

	/*
	 * Maven projects give us a pom.xml
	 * 
	 * What is a pom.xml file?
	 * 	pom: project object model
	 * 	pom file holds the meta data of the project
	 * 		-name of the project
	 * 		-external libraries aka JARS (dependencies)
	 * 		-package type e.g. jar or war
	 * 		-version # of the project 0.0.01-SNAPSHOT
	 * 		-version of java
	 * 
	 * if you change the pom.xml file in eclipse/sts
	 * 		you need to right click on project -> maven update project
	 * 
	 * pom.xml file replaces the .classpath
	 * .classpath is the binary version of the pom.xml
	 * 
	 * so what is actually the point of Maven
	 * 		a build tool (to build artifacts: jar or war)
	 * 		a dependency manager
	 */
	public static void main(String[] args) {
		System.out.println("testing maven project");

	}

}
