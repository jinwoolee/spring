package kr.or.ddit.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.user.model.UserVo;

/*
 * servlet
 * 1. HttpServlet 클래스를 상속
 * 2. @WebServlet 혹은 web.xml에 url-mapping 등록
 * 3. doGet, doPost 같은 doXXX메소드를 통해 서비스를 개발
 * 
 * spring controller
 * 1. @Controller 어노테이션 적용
 * 2. @RequestMapping 어노테이션 적용(class / method)
 */

@RequestMapping("/hello")
@Controller
public class HelloController {
	
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	// 사용자 요청 : localhost:8081/hello/hello.do url로 요청을 하게 되면
	//           아래의 메소드에서 요청을 처리
	// 만약 class에 적용한 @RequestMapping("/hello") 부분을 삭제 하게 되면
	// localhost:8081/hello.do url로 요청에 대해 hello() 메소드에서 요청을 처리하게됨
	@RequestMapping("/hello.do")
	public String hello() {
		
		//viewName을 리턴
		//internalResourceViewResolver 설정에 의해
		// prefix + viewName + suffix 위치의 리소스로 응답 위임한다
		// prefix : /WEB-INF/view
		// suffix : .jsp
		// viewName : hello
		// ==> /WEB-INF/view/hello.jsp
		// 기본 : forward
		return "hello";
	}
	
	
	/*
	 * servlet doGet, doPost : 메소드 인자가 HttpServletReuqest, HttServletResponse 두개로 고정
	 * spring controller 메소드 : 비교적 자유롭게 구성이 가능
	 * 							HttpServletRequest,HttpServletResponse,
	 * 						    HttpSession, 
	 * 							ValueObject,
	 * 							Model : view에서 표현할 데이터를 저장 
	 */
	@RequestMapping("/model")
	public String model(Model model) {
		List<String> rangers = new ArrayList<String>();
		rangers.add("brwon");
		rangers.add("cony");
		rangers.add("sally");
		
		//servlet : request.setAttribute("rangers", rangers);
		model.addAttribute("rangers", rangers);
		
		return "hello";
	}
	
	@RequestMapping("/request")
	public String request(HttpServletRequest request, Model model) {
		
		//기존 servlet 파라미터 확인 방식
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		model.addAttribute("userId", userId + "_attr");
		model.addAttribute("pass", pass + "_attr");
		
		//logger를 이용한 출력
		logger.debug("userId : {}", userId);
		logger.debug("pass : {}", pass);
		
		return "hello";
	}
	
	//value object의 속성이름과 동일한 이름의 파라미터를 자동으로 설정해준다
	@RequestMapping("/vo")
	public String vo(UserVo userVo, Model model) {
		
		logger.debug("userVo : {}", userVo );
		
		model.addAttribute("userVo", userVo);
		
		return "hello";
	}
	
	//spring mvc controller 메소드의 리턴타입
	//1.String : viewName
	//2.ModelAndView : 스프링 제공 객체
	//3.void : response 객체에 개발자가 직접 응답을 작성
	//ModelAndView
	// http://localhost:8081/hello/modelAndView
	@RequestMapping("/modelAndView")
	public ModelAndView modelAndView() {
		ModelAndView mav = new ModelAndView();
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brwon");
		rangers.add("cony");
		rangers.add("sally");
		
		// model.addAttribute("rangers", rangers);
		mav.addObject("rangers", rangers);
		
		//viewName
		mav.setViewName("hello");
		
		return mav;
	}
	
	//void
	@RequestMapping("/void")
	public void voidMehtod(HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		
		writer.write("<html>");
		writer.write("sproing voieMethod");
		writer.write("</html>");
		
	}
	
	// http://localhost:8081/hello/exception
	@RequestMapping("/exception")
	public String view() {
		throw new ArithmeticException();
	}
	

	
}




















