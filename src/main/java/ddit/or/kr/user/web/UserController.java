package ddit.or.kr.user.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ddit.or.kr.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * Method : userListAll
	 * 최초작성일 : 2017. 12. 29.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 조회
	 */
	@RequestMapping("/userListAll")
	public ModelAndView userListAll(){
		ModelAndView mav = new ModelAndView("user/userList");
		mav.addObject("userList", userService.userListAll());
		return mav;
	}

}
