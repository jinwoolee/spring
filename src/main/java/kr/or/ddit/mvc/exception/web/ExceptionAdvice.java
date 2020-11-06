package kr.or.ddit.mvc.exception.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ExceptionHandler({ArithmeticException.class})
	public String handler() {
		logger.debug("ExceptionController.handler()");
		
		//에러를 처리할 화면
		return "exception/arithmetic";
	}
}
