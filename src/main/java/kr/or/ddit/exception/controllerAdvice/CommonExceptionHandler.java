package kr.or.ddit.exception.controllerAdvice;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
	Logger logger = LoggerFactory.getLogger(CommonExceptionHandler.class);
	
	@ExceptionHandler({ArithmeticException.class})
	public String handelException(Throwable e, HttpServletResponse response) {
		logger.debug("CommonExceptionHandler handelException");
		
		return "error/arithmeticException";
	}
}
