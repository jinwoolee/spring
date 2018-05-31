package kr.or.ddit.requestHeader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("requestHeaderController")
public class RequestHeaderController {
	Logger logger = LoggerFactory.getLogger(RequestHeaderController.class);
	
	//http://localhost:8080/requestHeaderController/requestHeader.do
	@RequestMapping("/requestHeader.do")
	public String requestHeader(@RequestHeader(value="user-agent", required=false)String userAgent, Model model) {
		
		model.addAttribute("userAgent", userAgent);
		
		return "test/requestHeader";
	}
	
}