package com.util;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect()
public class LogAspect {
	public static Logger logger = Logger.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.service..*.*(..))")
	public void pointcut() {};
	
	@Before("execution(* com.service..*.*(..))")
	public void before(JoinPoint join) {
		logger.error("前置通知： " + join.getTarget().getClass().getName() + " 的 " + join.getSignature().getName()
	            + " 方法开始了。方法入参：" + Arrays.toString(join.getArgs()));
	}
	
	@AfterReturning(pointcut = "execution(* com.service..*.*(..))", returning = "result")
	public void afterReturning(JoinPoint join,Object result) {
		logger.error("后置通知：用 " + join.getTarget().getClass().getName() + " 的 " + join.getSignature().getName()
	            + " 方法正常结束了。方法返回值：" + result);
	}
}
