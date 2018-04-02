package ddit.or.kr.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//kr.or.ddit

/**
 * Logging 어드바이스 
 * LoggingAdvice.java
 *
 * @author sam
 * @since 2017. 12. 21.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 21. sam 최초 생성
 *
 * </pre>
 */
public class LoggingAdvice {
	private Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);
	
	/**
	 * Method : before
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 : 핵심 로직이 [실행되기 전] 로그 출력
	 */
	public void before(JoinPoint joinPoint){
		logger.debug("LoggingAdvice methodName {}", joinPoint.getSignature().getName()); 
		logger.debug("LoggingAdvice {}", "before");
	}
	
	/**
	 * Method : after
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 : 핵심 로직이 [실행된 후] 로그 출력
	 */
	public void after(JoinPoint joinPoint){
		logger.debug("LoggingAdvice methodName {}", joinPoint.getSignature().getName());
		logger.debug("LoggingAdvice {}", "after");
	}
	
	/**
	 * Method : afterReturnning
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 : 핵심로직이 [정상적으로 실행된후] 로그 출력 
	 */
	public void afterReturnning(JoinPoint joinPoint, Object retVal){
		logger.debug("loggingAdvice {}", "afterReturnning");
		logger.debug("loggingAdvice return value {}", retVal);
	}
	
	/**
	 * Method : afterThrowing
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param joinPoint
	 * @param excpetion
	 * Method 설명 : 핵심로직에서 [예외가 발생한경우] 로그 출력
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception exception){
		logger.debug("loggingAdvice {}", "afterThrowing");
	}
	
	/**
	 * Method : around
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 :핵심로직 [실행전], [실행후] 로그 출력
	 * @throws Throwable 
	 */
	public void around(ProceedingJoinPoint joinpoint) throws Throwable{
		logger.debug("loggingAdvice {}", "around before");
		
		//우리가 구현한 핵심 로직
		joinpoint.proceed();
		
		logger.debug("loggingAdvice {}", "around after");
	}
}










