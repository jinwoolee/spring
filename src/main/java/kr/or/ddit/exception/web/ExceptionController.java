package kr.or.ddit.exception.web;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.exception.NoFileException;

@Controller
public class ExceptionController {


	/**
	* Method : view
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 예외를 강제로 발생시키는 url 
	*/
	// http://localhost:8081/exception
	@RequestMapping("/exception")
	public String view() {
		throw new ArithmeticException();
	}
	
	// http://localhost:8081/responseStatus
	//response status 테스트를 위한 url
	@RequestMapping("/responseStatus")
	public String responseStatus() throws NoFileException{
		ClassPathResource resource = 
				new ClassPathResource("kr/or/ddit/config/db/mybatis-config.xnl");
		
		try {
			resource.getInputStream();
		} catch (IOException e) {
			throw new NoFileException();
		}
		
		return "error/arithmatic";				
	}

}











