package kr.or.ddit.hello.web.pathVariable;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pathVariableController")
public class PathVariableController {

	//http://localhost:8080/pathVariableController/pathVariable/brown
	@RequestMapping("/pathVariable/{userId}")
	public String pathVariable(@PathVariable("userId") String userId, Model model) {
		
		model.addAttribute("userId", userId);
		return "test/pathVariable";
	}
}