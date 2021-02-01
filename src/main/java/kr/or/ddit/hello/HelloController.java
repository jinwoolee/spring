package kr.or.ddit.hello;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.user.service.UserService;

@RequestMapping("hello")
@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	// localhost/hello/view ==> localhost/view 
	@RequestMapping("view")
	public String view(Model model, HttpServletRequest request) {
		logger.debug("HelloController.view() : {}", userService.selectUser("brown"));
		
		model.addAttribute("userVo", userService.selectUser("brown"));
		
		return "hello";
	}
}









