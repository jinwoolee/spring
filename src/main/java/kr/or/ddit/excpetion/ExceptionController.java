package kr.or.ddit.excpetion;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exceptionController")
public class ExceptionController {

	//localhost:8080/exceptionController/view
	@RequestMapping("/view")
	public String view() {
		throw new ArithmeticException();		
	}

	@ExceptionHandler({ArithmeticException.class})
	public String handelException(Throwable e, HttpServletResponse response) {
		return "error/arithmeticException";
	}
}
