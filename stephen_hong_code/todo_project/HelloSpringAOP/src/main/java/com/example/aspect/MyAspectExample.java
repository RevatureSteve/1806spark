package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*	An aspect is a modularization of cross cutting concerns
 * 		In Java, it takes the form a class filled with a collection of advice
 */
@Component("musicAspect")
@Aspect
public class MyAspectExample {
	/*
	 * 	An advice is an action taken by the aspect at a specific JoinPoint
	 * 		In Java, it takes the form of a method w/ an annotation
	 * 
	 * 	5 types of advice:
	 * 		Before - before the method
	 * 		After - after the method, regardless of success
	 * 		AfterReturning - after the method, successful return
	 * 		AfterThrowing - after some object is thrown (i.e. exception)
	 * 		Around - controls both before and after the method. the most powerful type of advice
	 * 
	 * 		A joinpoint is every possible place in the application where an advice may be run
	 * 		A pointcut is a selection of joinpoint, using a predicate
	 * 
	 * 		Pointcut expression:
	 * 			"*" is our wildcard for return types and method naming
	 * 			".." is our wildcard for parameter list
	 * 			"*" is for a SINGLE parameter in the parameter list
	 * 			You can specify an access modifier
	 */
	
	//	this is an advice, the entire method
	@Before("execution(* draw*(..))")
	public void startMusic(JoinPoint jp) {
		System.out.println("	--- start the fire tracks ---");
		System.out.println("	--- vibe these beats ---");
		
//		System.out.println(jp.getSignature());
	}
	
	//	"execution..." refers to as the pointcut
	@AfterReturning("execution(* draw*(..))")
	public void stopMusic(JoinPoint jp) {
		System.out.println("		--- stop the beats ---");
	}
	
	@Around("execution(* sc*(..))")
	public void testAroungAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("wetting clay");
		pjp.proceed();
		System.out.println("clean up mess");
	}

}
