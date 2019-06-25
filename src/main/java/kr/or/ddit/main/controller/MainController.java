package kr.or.ddit.main.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
/*
  servlet 
  	- extends HttpServlet
  	- servlet-mapping (web.xml, @WebServlet)
  	- service -> doXXX
  	
  spring
     -	pojo (Plain Old Java Object), @Controller
     - @RequestMapping(class, method)
     - @RequestMapping에 설정한 url method 호출
 */

import kr.or.ddit.user.model.UserVo;

@Controller
@SessionAttributes("rangers")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	// 메소드에 적용된 @ModelAttribute
	// @RequestMapping이 붙은 메소드가 실행될때(요청이 처리될때)
	// @ModelAttriubute가 적용된 메소드가 리턴하는 값을 Model객체에 자동적으로 넣어준다
	// localhost/main --> @RequestMapping("/main") : mainView --> Model에는 rangers 속성이 들어가 있다
	// localhost/mainMav --> @RequestMapping("/mainMav") : mainViewMav --> Model에는 rangers 속성이 들어가 있다
	
	@ModelAttribute("rangers")
	public List<String> rangers(){
		logger.debug("{}", "rangers()");
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
		
		return rangers;
	}
	
	/** 
	 * Method   : mainView
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param model
	 * @return 
	 * Method 설명 : main 페이지 요청(viewName)
	 */
	@RequestMapping("/main")
	public String mainView(Model model , @ModelAttribute("userVo")UserVo userVo) {
		
		logger.debug("mainView");
		logger.debug("model.asMap().get(\"rangers\") : {}", model.asMap().get("rangers") );
		
//		UserVo userVo = new UserVo();
//		userVo.setName("브라운");
//		model.addAttribute("userVo", userVo);
		
		logger.debug("userVo : {}", userVo);
		
		
		// prefix : /WEB-INF/views/
		// surffix : .jsp
		
		//  prefix + viewName + surffix
		//  /WEB-INF/views/main.jsp
		
		//아래 문장은 다음과 동일하다
		//request.setAttribute("mainUserId", "brown");
		model.addAttribute("mainUserId", "brown");
		
		//viewName
		return "main";
	}
	
	/** 
	 * Method   : mainViewMav
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : main 페이지 요청(ModelAndView 사용)
	 */
	@RequestMapping("/mainMav")
	public ModelAndView mainViewMav(@ModelAttribute("rangers") List<String> rangers) {
		logger.debug("mainViewMav : {}", rangers);
		
		//viewName을 기반으로 ModelAndView 객체를 생성
		ModelAndView mav = new ModelAndView("main");
		
		//위 문장은 아래 두 문장과 같다
		//ModelAndView mav = new ModelAndView();
		//mav.setViewName("main");
		
		//model.addAttribute("mainUserId", "brown");
		mav.addObject("mainUserId", "brown");
		
		return mav;
	}

	/** 
	 * Method   : pathvariable
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param userId
	 * @return 
	 * Method 설명 : pathvarible로 부터 사용자 아이디 가져오기 (ex : 도서관 사업소)  
	 */
	// localhost/main/pathvariable/brown
	// localhost/main/pathvariable/sally
	@RequestMapping("/main/pathvariable/{userId}")
	public String pathvariable(@PathVariable("userId") String userId) {
		logger.debug("userId : {}", userId);
		return "main";
	}
	
	/** 
	 * Method   : header
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @param accept
	 * @return 
	 * Method 설명 : Accept 헤더 정보 가져오기
	 */
	@RequestMapping("/main/header")
	public String header(@RequestHeader(name = "Accept" /*, required = false*/) String accept) {
		logger.debug("Accept : {}", accept);
		return "main";
	}
}












