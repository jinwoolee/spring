package kr.or.ddit.multipart.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("multipartController")
public class MultipartResolverController {
	Logger logger = LoggerFactory.getLogger(MultipartResolverController.class);
	
	//http://localhost:8080/multipartController/multipartView
	@RequestMapping("/multipartView")
	public String multipartView() {
		return "test/multipartView";
	}
	
	//http://localhost:8080/multipartController/multipart.do
	//@RequestPart, @RequestParam
	@RequestMapping("/multipart.do")
	public String multipart(MultipartHttpServletRequest request,
							@RequestPart("attach")MultipartFile multipartFile,
							@RequestParam("attach")MultipartFile multiRequestParamFile,
							HttpServletRequest hsr,
							Model model) {
		MultipartFile file = request.getFile("attach");
		logger.debug(file.getName());
		
		String path = hsr.getServletContext().getRealPath("/upload");
		try {
			file.transferTo(new File(path + File.separator + file.getOriginalFilename()));
			
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		model.addAttribute("fileName", file.getName());
		model.addAttribute("fileSize", file.getSize());
		
		model.addAttribute("multipartFileName", multipartFile.getName());
		model.addAttribute("multipartFileSize", multipartFile.getSize());
		
		model.addAttribute("multiRequestParamFileName", multiRequestParamFile.getName());
		model.addAttribute("multiRequestParamFileSize", multiRequestParamFile.getSize());
		
		model.addAttribute("userId", request.getParameter("userId"));
		model.addAttribute("hsrUserId", hsr.getParameter("userId"));
		
		return "test/multipartResult";
	}
}