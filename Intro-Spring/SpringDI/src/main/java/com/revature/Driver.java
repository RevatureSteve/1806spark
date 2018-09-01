package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.pojo.House;
import com.revature.service.AppService;

public class Driver {

	/*
	 * Spring DI: Dependency Injection
	 * 
	 * Spring is going to hold our dependencies (our objects) 
	 * 	and inject them where need (apply new object())
	 * 
	 * What is needed for Spring to do DI?
	 * 	 Configure the spring container
	 * 		-by xml
	 * 		-by @s
	 * 		-This example will be using XML 
	 * 
	 * How instantiate a spring container?
	 * 		-beanFactory (old) the parent class, lazy loads beans
	 *		-applicationContext (new) the child class, eagerly loads beans, support for I18N: Internationalization and Localization 
	 * 
	 * 	Spring Exceptions:
	 * 		NoSuchBeanDefinitionException: Trying to DI a bean with a bad ID reference, 
	 * 							the object you are trying to inject is not managed by the Spring Bean Container
	 * 		#1-BeanCreationException: same as above or bad configuration of the bean
	 * 
	 * 	Autowiring - Letting Spring decide how to inject your dependencies: automagical process
	 * 					1. byName
	 * 					2. byType
	 * 					3. constructor
	 * 					4. no -don't autowire
	 * 					5. default -no
	 * 					6. @Autowired 
	 * 
	 *  Beanwiring - Developer explicitly stating how to wire your dependencies
	 *  	
	 *  Spring @s:
	 *  	@Autowired -injects a dependency found in the Spring Bean Container
	 *  	@Qualifer - This annotation may be used on a field or parameter as a qualifier for candidate beans when autowiring. 
	 *  				It may also be used to annotate other custom annotations that can then in turn be used as qualifiers.
	 *		@Component - basic spring bean
	 *			@Service - bean that handles service layer logic
	 *			@Repository - bean that handles dao layer logic   
	 * 
	 */
	//AutoWiring Example and other @-annotations
	public static void main(String[] args) {
		System.out.println("hello spring!");
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
		AppService app = (AppService) ac.getBean("as"); //grab a bean in the Spring Bean Container
		app.saveHouse();
		
		System.out.println("end of app");
	}
	
	
	
	
	
//	xmlDIExample
//	public static void main(String[] args){
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//								//3 ways of getting your configuration file XmlWeb-, FileSystemXml-, ClassPathXml-
//		House house = (House) ac.getBean("houseId");
//		System.out.println(house);
//		
//		House anotherHouse = (House) ac.getBean("houseId");
//		anotherHouse.setName("another house");
//		anotherHouse.setWallColor("red");
////		
//		System.out.println(house);
//		System.out.println(anotherHouse);
//	}

}
