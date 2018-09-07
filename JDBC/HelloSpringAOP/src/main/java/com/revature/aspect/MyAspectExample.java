package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/*
 * An aspect is a modularization of cross cutting concerns.
 * 		In java, it takes the form a class filled with 
 * 		a collection of advice.
 */
@Component("musicAspect")
@Aspect
public class MyAspectExample {
	/*	An advice is an action 
	 * 
	 * 	5 Types of Advice
	 * 		before - before the method
	 * 		after - after the method, regardless of the success
	 * 		afterReturning - after the method, successful return
	 * 		afterThrowing - after some object is thrown (i.e. exception)
	 * 		around - put, it can control both before and after the method.
	 * 			this is the most powerful type of adivce
	 * 
	 * 		A jointpoint is every possible place in the application 
	 * 			where an advice may be run
	 * 		A pointcut is a selection of jointpoints, using a predicate
	 * 
	 * 		Pointcut expression:
	 * 			"*" is our wildcard for return types and method naming 
	 * 			".." is our wildcard for our parameter list
	 * 			"*" is also out wildcard for a single parameter
	 * 				in the parameter list
	 * 			and YES you can specify an access modifier
	 */
	
//	@Before("execution(* *(..))")
//	@Before("execution(* draw*(..))")
	@Before("execution(int *raw*(int))")
	public void startMusic(JoinPoint jp) {
		System.out.println("--- start the tracks ---");
		System.out.println("--- vibe these beats ---");
	}
	
	
	@AfterReturning("execution(* draw*(..))")
	public void stopMusic(JoinPoint jp) {
		System.out.println("	--- stop the tracks ---");
	}
	
	//this "execution..." portion of the advice is referred to as the pointcut
	@Around("execution(* sc*(..))")
	public void testAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("wetting the clay");
		pjp.proceed();
		System.out.println("cleaning up mess");
	}

}
