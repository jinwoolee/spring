package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	//userService 스프링 빈 주입
	@Resource(name="userService")
	private UserServiceInf userService;
	
	@RequestMapping("/loginView")
	public String loginView() {
		return "login/login"; 
	}
	
	@RequestMapping(value="/loginProcess", method=RequestMethod.POST )
	public String loginProcess(UserVo userVo) {
		
		if("brown".equals(userVo.getUserId()) &&
		   "brownpass".equals(userVo.getPass()))
			return "main";
		else 
			return "login/login";
	}
	
	/**
	* Method : userAllList
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	*/
	@RequestMapping("/userAllList")
	public String userAllList(Model model) {
		
		//userService 사용자 전체 정보조회
		
		/*
		 * UserServiceInf userService = new UserService();
		 * List<UserVo> userList = userService.selectUserAll();
		 */
		List<UserVo> userList = userService.selectUserAll();
		
		/*request.setAttribute("userList", userList);*/
		model.addAttribute("userList", userList);
		
		/*
		 * RequestDispatcher rd = 
				request.getRequestDispatcher("/user/userAllList.jsp");
		   rd.forward(request, response);
		 */
		
		return "user/userAllList";
	}
	
	
	@RequestMapping("/userPageList")
	public String userPageList(/*Model model, PageVo pageVo*/) {
		/*
		 * //userservice 생성
			UserServiceInf userService = new UserService();
		 */
		// spring 컨테이너로부터 bean을 주입받기 때문에 new 연산자를 통해 생성할 필요 없음
		
		
		/*
		 * int page = Integer.parseInt(request.getParameter("page"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			PageVo pageVo = new PageVo();
			pageVo.setPage(page);
			pageVo.setPageSize(pageSize);
		 */
		//controller method 매개변수로 선언
		
		
		/*
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		 
		
		//페이지 리스트
		List<UserVo> userList =
					(List<UserVo>) resultMap.get("userList");
		
		//페이지 건수
		int pageCnt = (int) resultMap.get("pageCnt");
		
		//request 객체에 저장
		request.setAttribute("userList", userList);
		request.setAttribute("pageCnt", pageCnt);
		*/
		
		//Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		//model.addAllAttributes(resultMap);
		
		/*
		 request.getRequestDispatcher("/user/userPageList.jsp")
			.forward(request, response);
		 */
		
		return "user/userPageList";
	}
	
	@RequestMapping("/userPageListAjax")
	public String userPageListAjax(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "jsonView";
	}
	
	@RequestMapping("/userPageListAjaxHtml")
	public String userPageListAjaxHtml(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "user/pageListHtml";
	}
	
	@RequestMapping("/userPaginationAjaxHtml")
	public String userPaginationAjaxHtml(Model model, PageVo pageVo) {
		
		Map<String, Object> resultMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resultMap);
		
		return "user/pagiNationHtml";
	}
	

	@RequestMapping("/userDetail")
	public String userDetail(@RequestParam("userId")String userId,
							 Model model) {
		/*
		 String userId = request.getParameter("userId"); 
		 */
		// @RequestParam 어노테이션을 통해 설정
		
		/*
		 //사용자 아이디에 해당하는 사용자 정보 조회
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(userId);
		 */
		UserVo userVo = userService.selectUser(userId);
		
		/*
		  request.setAttribute("userVo", userVo); 
		 */
		model.addAttribute("userVo", userVo);
		
		/*request.getRequestDispatcher("/user/userDetail.jsp")
		.forward(request, response);
		*/
		
		return "user/userDetail";		
	}
	
	@RequestMapping(value="/userForm", method= RequestMethod.GET)
	public String userFormView() {
		return "user/userForm";
	}
	
	@RequestMapping(value="/userForm", method= RequestMethod.POST)
	public String userForm(@RequestPart("profilePic")MultipartFile part,
						   HttpServletRequest request,
						   UserVo userVo) {
		
		try {
			if(part.getSize() > 0) {
				
				String path = 
						request.getServletContext().getRealPath("/profile");
				
				String fileName = part.getOriginalFilename();
				
				part.transferTo(new File(path + File.separator + fileName));
				
				userVo.setProfile("/profile/" + fileName);
			}
			else
				userVo.setProfile("");
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int insertCnt = userService.insertUser(userVo);
		
		return "redirect:/user/userPageList?page=1&pageSize=10";
		
	}
	
	
	@RequestMapping(value="/userUpdate", method=RequestMethod.GET)
	public String userUpdateView(@RequestParam("userId")String userId,
								 Model model){

		UserVo userVo = userService.selectUser(userId);

		model.addAttribute("userVo", userVo);
				
		return "user/userUpdate";
	}
	
	@RequestMapping(value="/userUpdate", method=RequestMethod.POST)
	public String userUpdate(@RequestPart("profilePic")MultipartFile part,
							 HttpServletRequest request,
							 UserVo userVo, Model model){
		
		//현재 user정보
		UserVo orgUserVo = userService.selectUser(userVo.getUserId());
		
		if(part.getSize() > 0) {
			String path = request.getServletContext().getRealPath("/profile");
			
			String fileName = part.getOriginalFilename();
			try {
				part.transferTo(new File(path + File.separator + fileName));
				userVo.setProfile("/profile/"+fileName);
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		else {
			
			userVo.setProfile(orgUserVo.getProfile());
		}
		
		//비밀번호 변경여부
		if(userVo.getPass() == null || userVo.getPass().equals(""))
			userVo.setPass(orgUserVo.getPass());
		else 
			userVo.setPass(KISA_SHA256.encrypt(orgUserVo.getPass()));
		
		
		int updateCnt = userService.updateUser(userVo);
		
		return "redirect:userDetail?userId="+userVo.getUserId();
	}
}













