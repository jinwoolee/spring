package kr.or.ddit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMessageContoller {
	
	// http://localhost:8081/messageView
	@RequestMapping("/messageView")
	public String messageView() {
		return "msg/view";
	}
}
