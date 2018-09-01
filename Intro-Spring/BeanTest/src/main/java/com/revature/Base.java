package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.pojo.Person;

@Configuration
public class Base {

	private static int i = 0;
	
	public static void main(String[] args) {
		System.out.println("@Bean testing");
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Person p = (Person) ac.getBean("person");
		Person p1 = (Person) ac.getBean("person");
		Person p2 = (Person) ac.getBean("person");
		System.out.println(p + " " + p1 + " " + p2);
		
	}
	
	
//	@Scope(value="prototype") //uncomment/comment to see the different outputs
	@Bean(name="person")
	public Person buildPerson(){
		Person p = new Person();
		p.setId(i++);
		return p;
	}
}
