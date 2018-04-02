package ddit.or.kr.exception.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoExceptionController {
	private Logger logger = LoggerFactory.getLogger(NoExceptionController.class);
	
	// localhost:8180/exception/noController/view
	@RequestMapping("/exception/noController/view")
	public void exceptionView(){
		logger.debug("/exception/noController/view {}", "exceptionView()");		
		throw new ArithmeticException(); 
	}

}






