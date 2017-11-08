	package kr.or.ddit.requestBody.web;
	
	import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseBody;
	
	import kr.or.ddit.test.model.TestVo;
	
	@Controller
	@RequestMapping("requestBodyController")
	public class RequestBodyController {
		Logger logger = LoggerFactory.getLogger(RequestBodyController.class);
		
		//http://localhost:8080/requestBodyController/requestBodyView
		@RequestMapping("/requestBodyView")
		public String view() {
			return "test/requestBodyView";
		}
		
		//http://localhost:8080/requestBodyController/requestBody.do
		@RequestMapping(value="/requestBody.do",
				produces={"application/json", "application/xml"},
			    consumes={"application/json"})
		@ResponseBody
		public TestVo result(@RequestBody TestVo testVo) {
			logger.debug("testVo : " + testVo);
			
			testVo.setUserId(testVo.getUserId() + " modify");
			
			logger.debug("testVo : " + testVo);
			
			return testVo;
		}
		
		//http://localhost:8080/requestBodyController/requestBody.do
		@RequestMapping(value="/requestStringBody.do"/*,
			produces={"application/json", "application/xml"},
			    consumes={"application/json", "application/xml"}*/)
		@ResponseBody
		public String result(@RequestBody String stringBody) {
			logger.debug("stringBody : " + stringBody);
			stringBody += " modify";
			
			return stringBody;
		}
	}