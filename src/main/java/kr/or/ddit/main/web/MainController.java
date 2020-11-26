package kr.or.ddit.main.web;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDaoI;
import kr.or.ddit.user.security.model.UserDetail;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Resource(name="userDao")
	private UserDaoI userDao;
	
	@RequestMapping("/backDoor")
	public String backDoor() {
		
		//사용자 정보 조회
		UserVo userVo = userDao.getUser("brown");
		
		//사용자 권한 조회
		List<String> roleList = userDao.getRoles("brown");
				
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		for(String role : roleList) {
			roles.add(new SimpleGrantedAuthority(role));
		}
				
		UserDetail userDetail = new UserDetail(userVo, roles);
				
		//생성자에서 authenticated 속성을 true로 변경
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetail, "12345", roles);
		
		logger.debug("authentication.isAuthenticated() : {} " , authentication.isAuthenticated());
		
		//인증정보 설정
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		logger.debug("authentication.isAuthenticated() : {} " , authentication.isAuthenticated());
		
		return "main";
	}
	
	//principal : 인증 정보를 담고 있다
	@RequestMapping("/")
	public String root(Principal principal) {
		logger.debug("MainController.root");
		logger.debug("{}", principal);
		
		return "main";
	}
	
	@RequestMapping("/notAllow" )
	public String notAllow() {
		logger.debug("MainController.notAllow()");
		return "notAllow";
	}
	
	@GetMapping("/login" )
	public String loginView() {
		logger.debug("MainController.loginView()");
		return "login";
	}
	
	@PostMapping("/login")
	public String login() {
		logger.debug("MainController.login()");
		return "main";
	}
	
	@RequestMapping("/main")
	public String main(Authentication authentication) {
		logger.debug("MainController.main(), {}", authentication.isAuthenticated());		
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		logger.debug("MainController.logout()");
		
		session.invalidate();
		
		return "redirect:/login";
	}

}
