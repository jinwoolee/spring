package ddit.or.kr.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LoggingAnnodation 어드바이스 
 * LoggingAnnodationAdvice.java
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

//Annotation을 이용한 aop 설정
@Aspect
public class LoggingAnnotationAdvice {
	private Logger logger = LoggerFactory.getLogger(LoggingAnnotationAdvice.class);
	
	//pointcut 등록을 위한 dummy메소드 생성
	@Pointcut(value="execution(* ddit.or.kr.aop.service.*.* (..))")
	public void dummy(){}
	
	/**
	 * Method : before
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 : 핵심 로직이 [실행되기 전] 로그 출력
	 */
	@Before("dummy()")
	public void before(JoinPoint joinPoint){
		logger.debug("LoggingAnnotationAdvice methodName {}", joinPoint.getSignature().getName()); 
		logger.debug("LoggingAnnotationAdvice {}", "before");
	}
	
	/**
	 * Method : after
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 : 핵심 로직이 [실행된 후] 로그 출력
	 */
	@After("dummy()")
	public void after(JoinPoint joinPoint){
		logger.debug("LoggingAnnotationAdvice methodName {}", joinPoint.getSignature().getName());
		logger.debug("LoggingAnnotationAdvice {}", "after");
	}
	
	/**
	 * Method : afterReturnning
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 : 핵심로직이 [정상적으로 실행된후] 로그 출력 
	 */
	@AfterReturning(pointcut="dummy()", returning="retVal")
	public void afterReturnning(JoinPoint joinPoint, Object retVal){
		logger.debug("LoggingAnnotationAdvice {}", "afterReturnning");
		logger.debug("LoggingAnnotationAdvice return value {}", retVal);
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
	@AfterThrowing(pointcut="dummy()", throwing="exception")
	public void afterThrowing(JoinPoint joinPoint, Exception exception){
		logger.debug("LoggingAnnotationAdvice {}", "afterThrowing");
	}
	
	/**
	 * Method : around
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 :핵심로직 [실행전], [실행후] 로그 출력
	 * @throws Throwable 
	 */
	@Around("dummy()")
	public void around(ProceedingJoinPoint joinpoint) throws Throwable{
		logger.debug("LoggingAnnotationAdvice {}", "around before");
		
		//우리가 구현한 핵심 로직
		joinpoint.proceed();
		
		logger.debug("LoggingAnnotationAdvice {}", "around after");
	}
}










