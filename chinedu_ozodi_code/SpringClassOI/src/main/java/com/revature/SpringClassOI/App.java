package com.revature.SpringClassOI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.revature.bean.Car;
import com.revature.bean.Employee;
import com.revature.bean.Engine;
import com.revature.dao.Manager;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\chin2\\mygitrepos\\1806spark\\chinedu_ozodi_code\\SpringClassOI\\src\\resources\\bean.xml");
        Car c = (Car) ac.getBean("fastCar");
        
        Engine e = new Engine();
        
        System.out.println("Car: " + c);
        
        EmployeeService eService = (EmployeeService) ac.getBean("employeeService");
        Employee emp = eService.getEmployeeById(6);
        
        System.out.println("Employee: " + emp);;
        
        
        ManagerService mService = (ManagerService) ac.getBean("ManagerService");
        
        Manager mgr = mService.getManagerById(1); 
        
        System.out.println("Mnanager: " + mgr);
    }
}
