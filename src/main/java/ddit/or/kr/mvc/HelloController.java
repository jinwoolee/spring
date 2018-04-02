package ddit.or.kr.mvc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

//@Controller : 해당 클래스가 Controller임을 명시한다.
//@RequestMapping : url과 controller 혹은 controller 내의 메소드에 mapping
//contrller(class) requesmapping : 1차요소
//contrller(mehtod) requesmapping : class에 적용된 url을 만족한후 2차 검증

/*url : /member/memberList.do : 회워정보조회
 * 		/member/insertMember.do : 회원정보 입력
 * 		/member/updateMember.do : 회원정보수정
 * 		/member/deleteMember.do : 회원정보삭제
 * 		/hello/hello.do 
 */
@Controller
@SessionAttributes("lineFriendsList")
//@RequestMapping("/{path}")
public class HelloController {
	private Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	//@ModelAttribute 를 적용한 메소드가 리턴한 객체는
	//Model 객체에 첨부가 된다
	//해당 클래스의 모든 @RequstMapping을 적용한 메소드에 공통적으로 적용
	@ModelAttribute("lineFriendsList")
	public List<String> getLineFriends(){
		logger.debug("getLineFriends()");
		
		List<String> lineFriendsList = new ArrayList<String>();
		lineFriendsList.add("brown");
		lineFriendsList.add("cony");
		lineFriendsList.add("sally");
		lineFriendsList.add("moon");
		lineFriendsList.add("james");
		
		return lineFriendsList;
	}
	

	@RequestMapping(value={"/sayHello.do", "/hello.do"})
	public String sayHello(Model model, @RequestParam("userId") String userId){
		logger.debug("sayHello()");
		//jsp/ servlet request 속성설정 : request.setAttribute
		//spring : model, map : model.addAtrribute 
		model.addAttribute("userName", "brown");
		model.addAttribute("userId", userId);
		
		return "sayHello";		
	}
	
	@RequestMapping(value="/requestMappingGet.do",
					method={RequestMethod.GET, RequestMethod.POST} )
	public String requestMappingGetMethod(){
		logger.debug("requestMappingGetMethod()");
		return "sayHello.jsp";
	}
	
	@RequestMapping(params="method=insertMember")
	public String requestMappingParam(){
		logger.debug("requestMappingParam()");
		return "sayHello.jsp";
	}
	
	@RequestMapping(params="userId")
	public String requestMappingParam2(){
		logger.debug("requestMappingParam2()");
		return "sayHello.jsp";
	}
	
	@RequestMapping("/lineFriends.do/{path}/{path2}")
	public String lineFriends(@PathVariable("path")String path, @PathVariable("path2")String path2){
		logger.debug("pathvariable test : {}", path);
		
		return "sayHello.jsp";
	}
	
	//메소드 파라미터에 적용된 @ModelAttribute
	//해당 파라미터에 @ModelAttribute 메소드에서 적용된 객체가 전달된다.
	@RequestMapping("/lineFriendsMA.do")
	public String lineFriendsMA(@ModelAttribute("lineFriendsList")List<String> list, Model model){
		model.addAttribute("customList", list);
		return "sayHello.jsp";
	}
	
	@RequestMapping("/lineFriendsSA.do")
	public String lineFriendsSA(){
		return "sayHello.jsp";
	}
	
	//@PathVariable 테스트
	//url의 일부를 메소드 인자로 받을수 있다
	//  /hello/lineFriends/brown --> model().attributeExists("friendName");
	@RequestMapping("/lineFriends/{name}")
	public String getLineFriend(@PathVariable("name")String lineFriendName, Model model){
		
		//name에 해당하는 line Friend 상세정보를 조회
		//model.addObject("friendVo", friendVo);
		model.addAttribute("friendName", lineFriendName + " hello");	//"brown hello"
		return "lineFriendView.jsp";
	}
	
	//localhost:8180/hello/partView
	@RequestMapping("/partView")
	public String partView(){
		return "mvc/partView";
	}
	
	//@RequestPart : @RequestPart 어노테이션 적용으로 실습 fail : 다시알아본다!!
	@RequestMapping("/uploadPicture")
	//public String uploadPicture(@RequestParam("picture") MultipartFile pictureFile, Model model){
	public String uploadPicture(MultipartHttpServletRequest request,  
					@RequestParam("picture")MultipartFile pictureFile , Model model){
		
		//MultipartFile pictureFile = request.getFile("picture");
		
		//pictureFile을 사용하여 파일을 server에 저장(outputstream, writer 파일을 생성)
		
		String fileNm = pictureFile.getOriginalFilename();		//brown.png
		String path = request.getServletContext().getRealPath("/upload");
		try {
			pictureFile.transferTo(new File(path + File.separator + fileNm));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fileNm", fileNm);
		
		return "mvc/uploadResult";
	}
	
	@RequestMapping("/pictureDownload")
	public ModelAndView pictureDownload(@RequestParam("fileNm")String fileNm){
		ModelAndView mav = new ModelAndView("fileDownloadView");	//custom fileDownloadView
		
		mav.addObject("fileNm", fileNm);
		return mav;
	}
	
	
	
	
	
	/**
	 * Method : mav
	 * 최초작성일 : 2017. 12. 22.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : ModelAndView 객체를 이용한 view, model 전달 예제
	 */
	@RequestMapping("/modelAndView.do")
	public ModelAndView mav(){
		
		//view
		//기존 : return "뷰이름"; //return type String
		//변경 : return ModelAndView;
		//ModelAndView 객체 view 설정 방법
		//1. new ModelAndView("뷰이름");   // new ModelAndView("uploadResult.jsp");
		//2. mav.setViewNaem("뷰이름");
		
		//1
		//ModelAndView mav = new ModelAndView("mav.jsp");
		
		//2
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mav.jsp");
		
		//속성을 설정하는 방법
		//기존 : 메소드 인자로 model, modelMap, map 객체를 선언
		//변경 : modelAndView 객체에 설정
		
		//1.mav.getModel()
		//2.mav.getModelMap()
		//3.mav.addObject, addAllObject
		
		mav.getModel().put("modelUserNm", "modelBrown");
		mav.getModelMap().addAttribute("modelMapUserNm", "modelMapBrown");
		mav.addObject("mavUsreNm", "mavBrown");
		
		return mav;
	}
	
	@RequestMapping("/helloTiles")
	public String helloTiles(){
		//tiles-config.xml의 <definition name="helloTiles" >을 찾아간다
		return "helloTiles";
	}
	
}










