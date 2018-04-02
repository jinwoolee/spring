package ddit.or.kr.exception.web;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoFileExceptionController {
	
	// localhost:8180/noFile/ioException
	@RequestMapping("/noFile/ioException")
	public String ioException() throws IOException {
		
		Resource resource = new ClassPathResource("ddit/or/kr/noDirectory/application-context.xml");
		resource.getInputStream();
		
		return "view";
	}
	
	// localhost:8180/noFile/noFileException
	@RequestMapping("/noFile/noFileException")
	public String noFileException() throws NoFileException {
		
		Resource resource = new ClassPathResource("ddit/or/kr/noDirectory/application-context.xml");
		
		try{
			resource.getInputStream();
		}catch(IOException e){
			throw new NoFileException();
		}
		
		return "view";
	}

}
