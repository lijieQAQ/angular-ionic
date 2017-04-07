package com.culture.util;  

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;


public class LogHelper implements MethodBeforeAdvice,AfterReturningAdvice{

	
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		
	}
	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		
	}

	

}
 