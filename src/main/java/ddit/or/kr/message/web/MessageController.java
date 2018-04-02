package ddit.or.kr.message.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ddit.or.kr.validator.model.BoardVo;

@Controller
@RequestMapping("/message")
public class MessageController {

	@ModelAttribute("languageMap")
	public Map<String, String> langugeMap(){
		
		Map<String, String> lauguageMap = new HashMap<String, String>();
		//database에서 관리되는 다국어 정보 조회
		
		lauguageMap.put("ko", "한국어");
		lauguageMap.put("en", "english");
		lauguageMap.put("ja", "日本語");
		
		return lauguageMap;
	}
	
	//localhost:8180/message/messageView
	@RequestMapping("/messageView")
	public String messageView(BoardVo boardVo, Model model){
		
		model.addAttribute("boardVo", boardVo);
		return "message/messageView";
	}
}





