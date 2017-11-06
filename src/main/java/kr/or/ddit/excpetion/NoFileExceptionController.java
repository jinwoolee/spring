package kr.or.ddit.excpetion;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("noFileExceptionController")
public class NoFileExceptionController {
	Logger logger = LoggerFactory.getLogger(NoFileExceptionController.class);
	
	//localhost:8080/noFileExceptionController/view
	@RequestMapping("/view")
	public String view(String fileInfo){
		
		try {
			Resource resource = new ClassPathResource("config/mybatis/sql-map-config-nofile.xml");
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return "view";
	}
}