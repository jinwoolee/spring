package kr.or.ddit.requestMapping.web;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.test.model.TestVo;

@Controller
@RequestMapping("requestMappingController")		//http://localhost:8080/requestMappingController
public class RequestMappingController {
	private Logger logger = LoggerFactory.getLogger(RequestMappingController.class);
	
	
	@RequestMapping("/method1")
	public String requestMappingController() {
		logger.debug("requestMappingController");
		return "test/test";
	}
	
	@RequestMapping("/method2")
	public String requestMappingController2() {
		logger.debug("requestMappingController2");
		return "test/test";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHttpMethod() {
		logger.debug("getHttpMethod");
		return "test/test";
	}
	
	//http://localhost:8080/requestMappingController?method=req&userId=brown
	@RequestMapping(method=RequestMethod.GET, params="method=req")
	public String getHttpMethodParam(HttpServletRequest request,
									 HttpServletResponse Response,
									 HttpSession sesion,
									 Locale locale,
									 @RequestParam("method") String method,
									 TestVo testVo,
									 Model model,
									 ModelMap modelMap,
									 Map map) {
		
		logger.debug("getHttpMethodParam");
		
		logger.debug(request.getParameter("method"));
		logger.debug(method);
		
		model.addAttribute("testVo", testVo);
		
		//view로 결과 전달을 위한 객체 : model, modelMap, map
		model.addAttribute("model", "modelValue");
		map.put("map", "mapValue");
		modelMap.addAttribute("modelMap", "modelMapValue");
		
		return "test/model";
	}
}