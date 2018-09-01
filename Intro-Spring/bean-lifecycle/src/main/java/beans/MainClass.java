package beans;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	/*
	 * Bean life cycle in Spring Bean Factory Container is as follows:								
	 * The spring container finds the bean’s definition from the XML file and instantiates the bean.								
	 * Using the dependency injection, spring populates all of the properties as 
	 * 		specified in the bean definition								
	 * If the bean implements the BeanNameAware interface, the factory calls 
	 * 	 setBeanName(), passing the bean’s ID.								
	 * If the bean implements the BeanFactoryAware interface, the factory calls 
	 * 	 setBeanFactory(), passing an instance of itself.								
	 * If there are any BeanPostProcessors associated with the bean, 
	 * 	their post- ProcessBeforeInitialization() methods will be called.
	 * If an init-method is specified for the bean, it will be called.
	 * Finally, if there are any BeanPostProcessors associated with the bean, 
	 * their postProcessAfterInitialization() methods will be called.								
	 */

	public static void main(String[] args) throws InterruptedException {
//		AbstractApplicationContext yoSpring = new ClassPathXmlApplicationContext( new String[]{"beans.xml", "processor.xml" });
		AbstractApplicationContext yoSpring = new ClassPathXmlApplicationContext("master.xml");
		Thread.sleep(5000);
		//FileSystemXmlApplicationContext("C:\spring\config\beans.xml");
		System.out.println(	yoSpring.getBean("jon", ParentBean.class).getSecret() );
		// shutting down the IoC container
//		yoSpring.close(); // fires right away
		yoSpring.registerShutdownHook(); // waits until application stops
		Thread.sleep(5000);
	}
}
