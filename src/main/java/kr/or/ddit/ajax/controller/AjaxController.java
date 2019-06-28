package kr.or.ddit.ajax.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;

@RequestMapping("/ajax")
@Controller
public class AjaxController {
	
	@Resource(name="userService")
	private IuserService userService;
	
	/** 
	 * Method   : view
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : ajax 호출용 view
	 */
	@RequestMapping("/view")
	public String view() {
		return "tiles.ajaxView";
	}
	
	@RequestMapping("/requestData")
	public String requestData(Model model) {
		
		model.addAttribute("pageVo", new PageVo(5, 10));
		model.addAttribute("pageVo2", new PageVo(2, 10));
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		model.addAttribute("rangers", rangers);
		/*
		 *   { pageVo : {page :5, pageSize: 10}}
		 *   { pageVo : {page :5, pageSize: 10}, pageVo2 : {page :2, pageSize: 10}}
		 *   { pageVo : {page :5, pageSize: 10}, pageVo2 : {page :2, pageSize: 10}, rangers : ["brown", "sally", "cony"]}
		 */
		
		return "jsonView";
	}
	
	@RequestMapping("/user")
	public String user(String userId, Model model) {
		
		UserVo userVo = userService.getUser(userId);
				
		model.addAttribute("userVo", userVo);
		// {userVo : {userId : 'brown', name : '브라운', alias : '곰'..........		}}
		
		return "jsonView";
	}
	
	@RequestMapping("/userHtml")
	public String userHtml(String userId, Model model) {
		
		UserVo userVo = userService.getUser(userId);
		model.addAttribute("userVo", userVo);
		
		return "user/userHtml";
	}
}














