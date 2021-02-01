package kr.or.ddit.user.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.user.service.UserService;

@RequestMapping("user")
@Controller
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;

	@RequestMapping("allUser")
	public String allUser(Model model) {
		
		model.addAttribute("userList", userService.selectAllUser());

		return "user/allUser";
	}
}
