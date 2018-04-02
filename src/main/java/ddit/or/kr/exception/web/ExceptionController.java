package ddit.or.kr.exception.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	private Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	// localhost:8180/exception/view
	@RequestMapping("/exception/view")
	public void exceptionView(){
		logger.debug("{}", "exceptionView()");
		
		throw new ArithmeticException(); 
	}
	
	@ExceptionHandler(value={ArithmeticException.class})
	public String exceptionHandle(){
		logger.debug("{}","exceptionHandle()");
		return "exception/arithmeticException";
	}

}






