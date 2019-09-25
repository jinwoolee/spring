package kr.or.ddit.user.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.model.UserValidator;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.util.model.FileInfo;

@RequestMapping("user/")
@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Resource(name = "userService")
	private IUserService userService;

	/**
	 * Method : userView 작성자 : SEM-PC 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 상세화면 요청
	 */
	// 사용자가 localhost:8081/spring/user/view.do
	@RequestMapping("view.do")
	public String userView() {
		logger.debug("userController.userView()");

		return "user/view";

		// prefix + viewName + suffix
		// WEB-INF/views/user/view.jsp
	}

	/**
	 * Method : userList 작성자 : SEM-PC 변경이력 :
	 * 
	 * @param model
	 * @return Method 설명 : 사용자 전체 리스트 조회
	 */

	@RequestMapping(path = "userList", method = RequestMethod.GET)
	public String userList(Model model) {

		model.addAttribute("userList", userService.getUserList());

		return "user/userList";
	}

	/**
	 * Method : userListOnlyHalf 작성자 : SEM-PC 변경이력 :
	 * 
	 * @param model
	 * @return Method 설명 : 사용자 정보 절반 조회
	 */
	@RequestMapping(path = "userListOnlyHalf", method = RequestMethod.GET)
	public String userListOnlyHalf(Model model) {

		model.addAttribute("userList", userService.getUserListOnlyHalf());

		return "user/userListOnlyHalf";
	}

	@RequestMapping(path = "userPagingList", method = RequestMethod.GET)
	public String userPagingList(@RequestParam(name = "page", defaultValue = "1") int p,
			@RequestParam(defaultValue = "10") int pagesize, Model model) {
		// public String userPagingList(Page page, Model model) {
		Page page = new Page(p, pagesize);
		model.addAttribute("pageVo", page);

		Map<String, Object> resultMap = userService.getUserPagingList(page);
		model.addAllAttributes(resultMap);

		//return "user/userPagingList";		//internalResourceViewResolver를 통한 응답
		return "tiles.userPagingList";
		
		// viewResolver order에 따라
		/*	1.tilesViewSolver가 tiles definition 파일중에
		 *    viewName과 일치하는 definition 이름을 검색
		 *    1-1. 검색이 될 경우 해당 definition을 이용하여 응답생성
		 *    1-2. 검색이 안될 경우 다음 우선순위를 갖는 viewResolver가 처리
		 *  2.beanNameViewResolver
		 *  3.interResourceViewResolver
		 */
		
	}

	/**
	 * Method : user 작성자 : SEM-PC 변경이력 :
	 * 
	 * @param userId
	 * @param model
	 * @return Method 설명 : 사용자 상세조회
	 */
	@RequestMapping("user")
	public String user(String userId, Model model) {
		model.addAttribute("user", userService.getUser(userId));
		//return "user/user";
		return "tiles.user";
	}

	@RequestMapping("userPicture")
	public void userPicture(String userId, HttpServletResponse response) throws IOException {

		User user = userService.getUser(userId);

		ServletOutputStream sos = response.getOutputStream();

		File picture = new File(user.getRealfilename());
		FileInputStream fis = new FileInputStream(picture);

		byte[] buff = new byte[512];
		int len = 0;

		while ((len = fis.read(buff, 0, 512)) != -1) {
			sos.write(buff, 0, len);
		}

		fis.close();
	}

	/**
	 * Method : userFormView 작성자 : SEM-PC 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 등록 화면 요청
	 */
	@RequestMapping(path = "userForm", method = RequestMethod.GET)
	public String userFormView() {
		return "user/userForm";
	}

	// 사용자 등록 요청
	@RequestMapping(path = "userForm", method = RequestMethod.POST)
	public String userForm(User user, BindingResult result, @RequestPart("picture") MultipartFile picture) {

		new UserValidator().validate(user, result);

		if (result.hasErrors())
			return "user/userForm";
		else {
			FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());

			// 첨부된 파일이 있을 경우만 업로드처리
			if (picture.getSize() > 0) {
				try {
					picture.transferTo(fileInfo.getFile());
					user.setFilename(fileInfo.getOrginalFileName());// originalFilename
					user.setRealfilename(fileInfo.getFile().getPath());
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			int insertCnt = userService.insertUser(user);

			if (insertCnt == 1)
				return "redirect:/user/user?userId=" + user.getUserId();
			else
				return "user/userForm";
		}
	}

	/**
	 * Method : userModifyView 작성자 : SEM-PC 변경이력 :
	 * 
	 * @param userId
	 * @param model
	 * @return Method 설명 : 사용자 수정화면
	 */
	@RequestMapping(path = "userModify", method = RequestMethod.GET)
	public String userModifyView(String userId, Model model) {
		model.addAttribute("user", userService.getUser(userId));
		return "user/userModify";
	}

	@RequestMapping(path = "userModify", method = RequestMethod.POST)
	public String userModify(User user, BindingResult result, Model model,
			@RequestPart("picture") MultipartFile picture) {

		new UserValidator().validate(user, result);

		if (result.hasErrors())
			return userModifyView(user.getUserId(), model);
		else {
			FileInfo fileInfo = FileUtil.getFileInfo(picture.getOriginalFilename());
			// 첨부된 파일이 있을 경우만 업로드처리
			if (picture.getSize() > 0) {
				try {

					// 기존 파일은 삭제한다
					User orgUser = userService.getUser(user.getUserId());
					
					if(orgUser.getRealfilename() != null) {
						File file = new File(orgUser.getRealfilename());
						file.delete();
					}

					picture.transferTo(fileInfo.getFile());
					user.setFilename(fileInfo.getOrginalFileName());// originalFilename
					user.setRealfilename(fileInfo.getFile().getPath());

				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}
			}

			int updateCnt = userService.updateUser(user);

			if (updateCnt == 1)
				return "redirect:/user/user?userId=" + user.getUserId();
			else
				return userModifyView(user.getUserId(), model);
		}
	}
	
	@RequestMapping(path="userPagingListAjaxView")
	public String userPagingListAjaxView() {
		return "user/userPagingListAjaxView";
	}
	
	@RequestMapping(path = "userPagingListAjax", method = RequestMethod.GET)
	public String userPagingListAjax(@RequestParam(name = "page", defaultValue = "1") int p,
			@RequestParam(defaultValue = "10") int pagesize, Model model) {

		Page page = new Page(p, pagesize);
		model.addAttribute("pageVo", page);

		Map<String, Object> resultMap = userService.getUserPagingList(page);
		model.addAllAttributes(resultMap);

		return "jsonView";
	}
	
	@RequestMapping(path = "userPagingListAjaxRequestBody", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> userPagingListAjaxRequestBody(@RequestBody Page page, Model model) {

		Map<String, Object> resultMap = userService.getUserPagingList(page);
		resultMap.put("pageVo", page);
		
		// {userList : [{userId: "brown", alais : "곰"...}, {...}, {...} ],
		//	paginationSize : 11 }
		return resultMap;
	}
	
	/**
	* Method : userPagingListHtmlAjax
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 페이징 리스트의 결과를 html로 생성한다 (jsp)
	*/
	@RequestMapping("userPagingListHtmlAjax")
	public String userPagingListHtmlAjax(@RequestParam(defaultValue = "1") int page,
										 @RequestParam(defaultValue = "10") int pagesize,
										 Model model) {
		
		Page pageVo = new Page(page, pagesize);
		Map<String, Object> resultMap = userService.getUserPagingList(pageVo);
		model.addAllAttributes(resultMap);
		model.addAttribute("pageVo", pageVo);
		
		return "user/userPagingListHtmlAjax";
	}
	
}













