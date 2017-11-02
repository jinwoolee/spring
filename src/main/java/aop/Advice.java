package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Advice {
	Logger logger = LoggerFactory.getLogger(Advice.class);

	// 타겟 메소드 실행전 수행
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.debug("beforMethod 실행 " + className + "." + methodName);
	}

	// 정상적으로 동작이 된 경우 실행됨
	public void afterReturningMethod(JoinPoint joinPoint, Object retVal) {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.debug("afterReturningMethod 실행 " + className + "." + methodName + ", return Value=" + retVal);
	}

	// 예외가 발생하고, 종료하는 경우 수행됨
	public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.debug("afterThrowingMethod 실행, " + className + "." + methodName);
		System.err.println("예외발생:" + ex.getMessage());
	}

	// 타켓 메소드 수행후 무조건 수행됨
	public void afterMethod(JoinPoint joinPoint) throws Exception {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.debug("afterMethod 실행 " + className + "." + methodName);
	}

	// 실행전 처리, 타겟 메소드 직접호출, 예외처리 가능
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		logger.debug("aroundMethod실행 - 1");
		long startTime = System.currentTimeMillis();
		Object[] args = joinPoint.getArgs();
		Object retVal = joinPoint.proceed(args);
		logger.debug("aroundMethod 실행 - 2 " + className + "." + methodName + ", lead time ="
				+ (System.currentTimeMillis() - startTime));
		return retVal;
	}
}
