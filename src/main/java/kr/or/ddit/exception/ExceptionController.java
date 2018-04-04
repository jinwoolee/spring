package kr.or.ddit.exception;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exceptionController")
public class ExceptionController {
	Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	//localhost:8080/exceptionController/view
	@RequestMapping("/view")
	public String view() {
		logger.debug("requestMapping /view");
		throw new ArithmeticException();		
	}

	@ExceptionHandler({ArithmeticException.class})
	public String handelException(Throwable e, HttpServletResponse response) {
		logger.debug("exceptionController handelException");
		return "error/arithmeticException";
	}
}