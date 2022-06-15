package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//set logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller..*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage() ")
			private void forAppFlow() {}
	
	
	//before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
			
		
		//display method calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==> in @Before: calling method: "+theMethod);
		
		
		//display arguments
		Object[] args = theJoinPoint.getArgs();
		
		for(Object arg: args) {
			System.out.println("==> aregument: "+ arg);
		}
	}
		
	//after returning advice
	
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method

		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("==> in @AfterReturning: calling method: "+theMethod);
		//display data
		
		
			System.out.println("==> result: "+ theResult);
	
		
		
	}
}
	
