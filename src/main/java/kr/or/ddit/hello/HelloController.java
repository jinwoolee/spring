package kr.or.ddit.hello;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.or.ddit.user.service.UserService;

@SessionAttributes("rangers")
@RequestMapping("hello")
@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Resource(name="userService")
	private UserService userService;
	
	@ModelAttribute(name = "rangers")
	public List<String> rangers(){
		
		logger.debug("helloController.rangers()");
		
		List<String> list = new ArrayList<String>();
		list.add("brown");
		list.add("sally");
		list.add("james");
		list.add("cony");
		list.add("moon");
		
		return list;
	}
	
	// localhost/hello/view ==> localhost/view 
	@RequestMapping("view")
	public String view(Model model,
			@ModelAttribute(name = "rangers") List<String> rangers, 
			HttpServletRequest request) {
		
		logger.debug("HelloController.view() : {}", userService.selectUser("brown"));
		logger.debug("rangers : {} ", rangers);
		
		model.addAttribute("userVo", userService.selectUser("brown"));
		
		return "hello";
	}
	
	// hello/path/subpath
	
	// hello/path/brown
	// hello/path/cony
	// hello/path/moon
	@RequestMapping("path/{subpath}")
	public String pathVariable(@PathVariable("subpath") String subpath, Model model,
			@RequestHeader(name = "User-Agent") String userAgent) {
		
		//User-Agent 값 로거로 출력
		logger.debug("userAgent : {}", userAgent);
		
		model.addAttribute("subpath", subpath);
		
		return "hello";
	}
}













