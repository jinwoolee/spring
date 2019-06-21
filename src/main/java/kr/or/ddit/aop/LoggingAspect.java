package kr.or.ddit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAspect {
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	public void before(JoinPoint joinPoint) {
		logger.debug("Logging Aspect before method");
	}
	
	public void after(JoinPoint joinPoint) {
		logger.debug("Logging Aspect after method");
	}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//business logic 실행전
		logger.debug("Logging Asepct around method before");
		
		//business logic 실행
		logger.debug("method name : {}", joinPoint.getSignature().getName());
		
		Object[] methodArgs =joinPoint.getArgs();
		Object returnObj = joinPoint.proceed(methodArgs);
		
		//business logic 실행후
		logger.debug("Logging Asepct around method after");
		
		return returnObj;
	}
}









