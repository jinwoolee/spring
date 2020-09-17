package kr.or.ddit.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@RequestMapping("/main")
	public String main(String userNm) {
		
		logger.debug("userNm : {}", userNm);
		
		return "main/main";
	}
	
	@RequestMapping("/user")
	public String user(String userNm) {
		
		logger.debug("userNm : {}", userNm);
		
		return "user/user";
	}
}
