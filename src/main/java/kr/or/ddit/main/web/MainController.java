package kr.or.ddit.main.web;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	//principal : 인증 정보를 담고 있다
	@RequestMapping("/")
	public String root(Principal principal) {
		logger.debug("MainController.root");
		logger.debug("{}", principal);
		return "main";
	}
	
	@RequestMapping("/main")
	public String main() {
		logger.debug("MainController.main");		
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		logger.debug("MainController.logout");
		return "redirect:/login";
	}

}
