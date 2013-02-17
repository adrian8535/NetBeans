package org.koushik.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	@Before("allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {
		//System.out.println(joinPoint.toString());	
	}
/*	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("2nd executed");
	}*/
	
	@AfterReturning(pointcut="args(name)", returning="returnString")
	public void StringArgumentMethods(String name, Object returnString) {
		System.out.println("Method that takes string args has been called. Value: " + name + ". Output: " + returnString);
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void ExceptionAdvice(String name, Exception ex) {
		System.out.println("Exception thrown " + ex);
	}
	
	@Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) { 
		
		Object returnValue = null; 
		
		try {
			System.out.println("Before advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After returning"); 
		} catch (Throwable e) {
			System.out.println("After throwing"); 
		}
		System.out.println("After finally");
		return returnValue;
	}
	
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	@Pointcut("within(org.koushik.javabrains.model.Circle)")
	public void allCircleMethods() {}
	
}
