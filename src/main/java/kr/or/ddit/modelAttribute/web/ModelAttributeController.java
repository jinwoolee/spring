package kr.or.ddit.modelAttribute.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.test.model.TestVo;

@Controller
@RequestMapping("/modelAttributeController")
public class ModelAttributeController {
	Logger logger = LoggerFactory.getLogger(ModelAttributeController.class);
	
	//http://localhost:8080/modelAttributeController/original?userId=brown
	@RequestMapping("/original")
	public String subMethod(HttpServletRequest req, Model model) {
		TestVo testVo = new TestVo();
		testVo.setUserId(req.getParameter("userId"));
		
		model.addAttribute("testVo", testVo);
		
		return "test/modelAttribute";
	}
	
	//http://localhost:8080/modelAttributeController/modelAttribute?userId=brown
	//파라미터를 @modelAttribute를 설정한 객체에 바인딩 하며, 바인딩 된 객체를 view에 자동으로 넘긴다.
	@RequestMapping("/modelAttribute")
	public String subMethod(@ModelAttribute("testVo") TestVo tstVo, @ModelAttribute("boardGbList") List<String> boardGbList) {
		boardGbList.add("add gb");
		return "test/modelAttribute";
	}	
	
	//@ModelAttribute("boardGbList")
	public List<String> boardGbList(){
		List<String> boardGbList = new ArrayList<String>();
		boardGbList.add("notice");
		boardGbList.add("alram");
		boardGbList.add("birthDay");
		boardGbList.add("business");
		
		return boardGbList;
	}
}