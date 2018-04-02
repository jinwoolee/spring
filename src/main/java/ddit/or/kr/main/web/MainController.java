package ddit.or.kr.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * main controller
 * MainController.java
 *
 * @author sam
 * @since 2017. 12. 22.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 22. sam 최초 생성
 *
 * </pre>
 */
@Controller
@RequestMapping("/main")
public class MainController {
	
	// localhost:8180/main/mainView.do
	@RequestMapping("/mainView.do")
	public String mainView(){
			
		// prefix : /WEB-INF/view/
		// suffing : .jsp
		
		///WEB-INF/view/main/main.jsp
		return "main/main";
	}
}








