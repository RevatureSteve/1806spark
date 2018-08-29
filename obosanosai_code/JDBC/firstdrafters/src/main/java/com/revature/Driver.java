package com.revature;

import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;
import com.revature.domain.Employee;
import com.revature.domain.Manager;
import com.revature.service.AppService;

public class Driver {
	
	/*
	 * Finally using a Maven project!
	 *      Maven projects give us a pom.xml
	 *      
	 *  What is a pom.xml file?
	 *     pom: project object model
	 *     The pom file holds the meta data of the project
	 *         - name of project
	 *         - external libraries aka JARS (dependencies)
	 *         - package type e.g. jar or war
	 *         - version # of the project 0.0.1-SNApSHOT
	 *         - version of java being used 
	 *         
	 *  Remember that XML, JSON, HTML are not programming languages
	 *       They are common formats that are machine and human readable.
	 *       
	 *       *NOTE: if you change the pom.xml file in eclipse/sts(which you should always do),
	 *              you need to right click on project -> maven -> update project*
	 *              
	 *        The pom.xml file replaces the .classpath
	 *              which is a binary version of the pom.xml file
	 *              
	 *   So what actually is Maven?
	 *       It is a build toll ( to build artifacts:jar or war)
	 *       a dependency manager (jar manager)
	 */
   public static void main(String[] args) {
    System.out.println("testing a maven project");
    // start implementing some of the use cases
    // maybe start with login- what's needed? (hard-coded)
    // Service Class for:
    //    login()
    //    -compare usernameInput w/ usernameDb
    //   - compare pwInput w/ pwDb
    // UserDoa:
    //     get Username/pw
    // Done - pojo:
    //     User: uId, username, pw
    //       Task:tId, uId,tName, tslevelID, tslevel
    
    String emailInput ="jj@jj.com";
    String pwInput ="123";
    

   Manager validManager = new AppService().login(new Manager(0,emailInput,pwInput));
   System.out.println("Is the manager valid: " + validManager);
   
   Employee validEmployee = new AppService().login(new Employee(0,emailInput,pwInput));
   System.out.println("Is the employee valid: " + validEmployee);
// UserDao userDao  = new UserDaoImpl();
   // cannot do.. method chaining is returning a User object not a UserDao object
 //UserDao userDao  = new UserDaoImpl().getUserByUsername(usernameInput);
// User user  = new UserDaoImpl().getUserByUsername(usernameInput);
	}

}
