package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //will be the core class of a feature
@Component
public class AspectExample {
		/*
		 *  Log to the console when certain methods are called
		 * 
		 */
	
	@Before("execution(* com.revature.service.AppService.play*(..))")
	public void highjackPlays(JoinPoint jp){
		System.out.println("Highjacking the 2 play* methods");
		jp.getArgs();
	}
	
	@Around("execution(* com.revature.service.AppService.run*(..))")
	public void testAroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("set up rides");
	
		System.out.println(pjp.getSignature());
		pjp.proceed();
		System.out.println("clean up rides");
		
		
	}
	
}
