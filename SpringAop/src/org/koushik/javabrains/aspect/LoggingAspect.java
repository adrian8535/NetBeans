package org.koushik.javabrains.aspect;

import org.aspectj.lang.JoinPoint;
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
	
	@Before("args(String)")
	public void StringArgumentMethods() {
		System.out.println("Method that takes string args has been called");
	}
	
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	@Pointcut("within(org.koushik.javabrains.model.Circle)")
	public void allCircleMethods() {}
	
}
