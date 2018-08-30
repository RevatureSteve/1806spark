package beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProcessorBean implements BeanPostProcessor{

	public Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException {
		if(bean instanceof ParentBean){
			// do something special for parentbean
			System.err.println("AfterInitialization " + beanName + " " + bean);
		}
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException {
		if(bean instanceof ParentBean){
			// do something special for parentbean
			System.err.println("BeforeInitialization " + beanName + " " + bean);
		}
		return bean;
	}

}
