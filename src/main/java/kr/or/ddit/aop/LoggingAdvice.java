package kr.or.ddit.aop;




import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAdvice {
	
	private Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
	
	public void beforeMethod(JoinPoint joinPoint){
		logger.debug("loggingAdvice before");
	}
	
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










