package kr.or.ddit.exception;

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
	
	//localhost:8080/noFileExceptionController/ioFileExcpetion
	@RequestMapping("/ioFileExcpetion")
	public String ioException(String fileInfo) throws IOException{
		Resource resource = new ClassPathResource("config/mybatis/sql-map-config-nofile.xml");
		
		//존재하지 않는 파일에 대한 inputstream 접근으로 IOException 발생
		resource.getInputStream();
		
		return "view";
	}
	
	//localhost:8080/noFileExceptionController/noFileExcpetion
	@RequestMapping("/noFileExcpetion")
	public String noFileException(String fileInfo) throws NoFileException{
		Resource resource = new ClassPathResource("config/mybatis/sql-map-config-nofile.xml");
		
		try {
			//존재하지 않는 파일에 대한 inputstream 접근으로 IOException 발생
			resource.getInputStream();
		}catch(IOException e) {
			throw new NoFileException();
		}
		
		return "view";
	}
}