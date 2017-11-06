package kr.or.ddit.excpetion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("noExceptionController")
public class NoExceptionController {
	Logger logger = LoggerFactory.getLogger(NoExceptionController.class);
	
	//localhost:8080/noExceptionController/view
	@RequestMapping("/view")
	public String view() {
		throw new ArithmeticException();		
	}
}