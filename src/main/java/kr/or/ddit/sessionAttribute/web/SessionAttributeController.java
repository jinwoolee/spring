package kr.or.ddit.sessionAttribute.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("boardGbList")
@RequestMapping("sessionAttributeController")
public class SessionAttributeController {
	Logger logger = LoggerFactory.getLogger(SessionAttributeController.class);
	
	//localhost:8080/sessionAttributeController/sessionAttributeView
	@RequestMapping("/sessionAttributeView")
	public String sessionAttributeView(HttpServletRequest req, ModelMap map) {
		
		List<String> boardGbList = (List<String>)map.get("boardGbList");
		for(String str : boardGbList)
			logger.debug(str);
		
		return "test/sessionAttribute";
	}
	
	@ModelAttribute("boardGbList")
	public List<String> boardGbList(){
		logger.debug("boardGbList() called ");
		List<String> boardGbList = new ArrayList<String>();
		boardGbList.add("notice");
		boardGbList.add("alram");
		boardGbList.add("birthDay");
		boardGbList.add("business");
		
		return boardGbList;
	}
}