package org.koushik.javabrains.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	@Before("allGetters()")
	public void LoggingAdvice() {
		System.out.println("Advice run. Get method call");	
	}
	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("2nd executed");
	}
	@Pointcut("execution(* get*())")
	public void allGetters() {}
}
