package com.springassgn.aspect;

import java.time.*;  

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.springassgn.service.*;

@Aspect
public class CalcExecTime {
	public LocalTime start;
	public LocalTime end;
	public static LocalTime execTime;	
 
	@Before("execution(* com.springassgn.service.EmployeeService.getAllEmployees(..))")
	public void logBeforeV2(JoinPoint joinPointBefore) {
		start = LocalTime.now();
		System.out.println("\n\n"+ joinPointBefore.getSignature().getName() + " method's Execution started at: " + LocalTime.now());	 
	}
	
	@After("execution(* com.springassgn.service.EmployeeService.getAllEmployees(..))")
	public void logAfterV2(JoinPoint joinPointAfter) {
		end = LocalTime.now();
		System.out.println("\n\n"+joinPointAfter.getSignature().getName() + " method's Execution completed at: " +LocalTime.now() );
		
		Duration duration = Duration.between(start, end);
		
        System.out.printf("\n\nTime taken to execute the function: " + duration.getNano()/10000000 + " milli seconds!\n\n");
	}
}