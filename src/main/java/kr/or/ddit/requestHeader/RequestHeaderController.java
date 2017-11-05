package kr.or.ddit.requestHeader;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.test.model.TestVo;

@Controller
@RequestMapping("requestHeaderController")
public class RequestHeaderController {
	Logger logger = LoggerFactory.getLogger(RequestHeaderController.class);
	
	//http://localhost:8080/requestHeaderController/requestHeader.do
	@RequestMapping("/requestHeader.do")
	public String requestHeader(@RequestHeader(value="user-agent", required=false)String userAgent, Model model) {
		
		model.addAttribute("userAgent", "userAgent");
		
		return "test/requestHeader";
	}
	
}