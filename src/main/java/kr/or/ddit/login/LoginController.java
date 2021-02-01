package kr.or.ddit.login;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;

@RequestMapping("login")
@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(path="view", method = {RequestMethod.GET})
	public String view() {
		
		logger.debug("loginController.view()");
		
		return "login";
	}
	
//	String userid = req.getParameter("userid"); 
//	String pass = req.getParameter("pass");
	//@RequestMapping(path="process")
	public String process(String userid, String pass, int price) {
		
		logger.debug("userid : {}", userid);
		logger.debug("pass : {}", pass);
		logger.debug("price : {}", price);
		
		return "";
	}
	
	//post 메소드만 처리하도록 설정
	@RequestMapping(path="process", method=RequestMethod.POST)
	public String process(UserVo userVo, HttpSession session) {
		
		logger.debug("userVo : {}", userVo);
		
		UserVo dbUser = userService.selectUser(userVo.getUserid());
		
		if(dbUser != null && userVo.getPass().equals(dbUser.getPass())) {
			session.setAttribute("S_USER", dbUser);
			return "main";
		}
		else {
			return "redirect:/login/view";
		}
	}
	
}








