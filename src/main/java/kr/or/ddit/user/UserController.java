package kr.or.ddit.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.util.model.PageVo;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Resource(name="userService")
	private IUserService userService;
	
	/**
	 * Method : userAllList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 전체 리스트 조회
	 */
	@RequestMapping("/userAllList")
	public String userAllList(Model model){

		List<UserVo> userList = userService.getAllUser();
		model.addAttribute("userList", userList);
		
		return "user/userAllList";
	}
	
	/**
	 * Method : userPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param pageVo
	 * @param model
	 * @return
	 * Method 설명 : 사용자 페이징 리스트 조회
	 */
	@RequestMapping("/userPagingList")
	public String userPagingList(PageVo pageVo, Model model){

		Map<String, Object> resultMap = userService.selectUserPagingList(pageVo);
		
		model.addAllAttributes(resultMap);
		model.addAttribute("pageSize", pageVo.getPageSize());
		model.addAttribute("page", pageVo.getPage());
		
		return "user/userPagingList";
	}
	
	@RequestMapping(path="/user", method=RequestMethod.GET)
	public String user(@RequestParam("userId")String userId, Model model){
		
		//userId parameter 확인
		//String userId = request.getParameter("userId");
		
		//해당 파라미터로 userService.selectUser(userId);
		//UserVo userVo = userService.selectUser(userId);
		UserVo userVo = userService.selectUser(userId);
		
		//조회된 user객체를 request객체에 속성으로 저장
		//request.setAttribute("userVo", userVo);
		model.addAttribute("userVo", userVo);
		
		//사용자 상세 화면을 담당하는 view로 forward
		//request.getRequestDispatcher("/user/user.jsp")
			//					.forward(request, response);
				
		return "user/user";
	}
	
	@RequestMapping("/profileImg")
	public void profileImg(HttpServletRequest req,
						   HttpServletResponse resp, 
						  @RequestParam("userId")String userId) throws IOException{
		
		resp.setHeader("Content-Disposition", "attachment; filename=profile.png"); 
		resp.setContentType("image.png"); 
		
		//1.사용자 아이디 파리미터 확인
		//String userId = req.getParameter("userId");
		
		//2.해당 사용자 아이디로 사용자 정보 조회(realFilename)
		UserVo userVo = userService.selectUser(userId);
		
		//3-1.realFilename이 존재할 경우
		//3-1-1. 해당 경로의 파일을 FileInputStream으로 읽는다
		FileInputStream fis;
		if(userVo != null && userVo.getRealFilename() != null)
			fis	= new FileInputStream(new File(userVo.getRealFilename()));
		
		//3-2.realFilename이 존재하지 않을 경우
		//3-2-1. /upload/noimg.png (application.getRealPath())
		else{
			
			 ServletContext application = req.getServletContext();
			 String noimgPath = application.getRealPath("/upload/noimg.png");
			 fis = new FileInputStream(new File(noimgPath));
		}
		
		//4.FileInputStream을 response객체의 outputStream 객체에 write
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff)) > -1){
			sos.write(buff);
		}
		
		sos.close();
		fis.close();
	}
	
	
	
}








