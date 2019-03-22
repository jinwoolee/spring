package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {
		
	}
	
	@Before("dummy()")
	public void beforeMethod(JoinPoint joinPoint){
		logger.debug("loggingAdvice before");
	}
	
	@After("dummy()")
	public void afterMethod(JoinPoint joinPoint){
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		logger.debug("LoggingAdvice after {}.{}", className, methodName);
	}
	
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		//핵심 로직 호출 전
		long startTime = System.currentTimeMillis();
		
		//핵심 로직 호출
		Object[] args = joinPoint.getArgs();
		Object returnObj = joinPoint.proceed(args);
		
		//핵심 로직 호출 후
		long endTime = System.currentTimeMillis();
		logger.debug("profilingTime : {}", endTime-startTime);
		
		return returnObj;
	}
}










