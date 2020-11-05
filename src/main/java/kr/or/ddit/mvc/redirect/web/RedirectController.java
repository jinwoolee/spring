package kr.or.ddit.mvc.redirect.web;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/redirect")
@Controller
public class RedirectController {
	private static final Logger logger = LoggerFactory.getLogger(RedirectController.class);
	
	//  localhost/redirect/process ==>  localhost/login/view
	//  
	//요청시 /login/view 로 리다이렉트 처리
	@RequestMapping("/process")
	public String process(Model model, HttpSession session,
						RedirectAttributes ra) {
		
		logger.debug("RedirectController.process()");
		
		model.addAttribute("msg", "hello, world");
		session.setAttribute("msg_s", "hello, wolrd_session");
		
		//리다이렉트 된 페이지에서 일회에 한해 사용할 수 있는 속성
		ra.addFlashAttribute("msg_ra", "hello, world_ra");
		ra.addAttribute("msg_ra_attr", "brown");

		//리다이렉트시 모델 객체에 추가된 속성을 리다이렉트 주소의 파라미터로 추가한다(get)
		//  "redirect:/login/view" ==> /login/view?msg=hello, world  
		
		return "redirect:/login/view";
	}
}








