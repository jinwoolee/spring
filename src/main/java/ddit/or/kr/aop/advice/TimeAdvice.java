package ddit.or.kr.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeAdvice {
	Logger logger = LoggerFactory.getLogger(TimeAdvice.class);
	
	
	public void around(ProceedingJoinPoint joinpoint) throws Throwable{
		long startTime = 0;
		long endTime = 0;
		
		logger.debug("TimeAdvice {}", "around before");
		startTime = System.currentTimeMillis();
		
		Thread.sleep(1000);
		
		//우리가 구현한 핵심 로직
		joinpoint.proceed();
		
		endTime = System.currentTimeMillis();
		logger.debug("TimeAdvice {}", "around after");
		logger.debug("수행시간 {} ", (endTime-startTime));
	}
}
