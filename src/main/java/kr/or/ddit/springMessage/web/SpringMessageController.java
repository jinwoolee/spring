package kr.or.ddit.springMessage.web;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.jdbc.model.BoardVo;

@Controller
@RequestMapping("springMessageController")
public class SpringMessageController {
	Logger logger = LoggerFactory.getLogger(SpringMessageController.class);
	
	@ModelAttribute("boardVo")
	public BoardVo boardVo() {
		return new BoardVo();
	}
	
	@ModelAttribute("countryMap")
	public Map<String, String> countryMap() {
		Map<String, String> countryMap = new HashMap<String, String>();
		countryMap.put("en", "english");
		countryMap.put("ko", "한국어");
		countryMap.put("jp", "日本語");
		
		return countryMap;
	}
	
	//localhost:8080/springMessageController/springMessageView
	@RequestMapping("/springMessageView")
	public String springMessageView(HttpServletRequest req, ModelMap map, Locale locale) {
		
		map.put("language", locale.getLanguage());		
		return "test/springMessage";
	}
}