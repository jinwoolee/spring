package ddit.or.kr.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;

import ddit.or.kr.SpringTestEnv;

@ContextConfiguration("classpath:/ddit/or/kr/mvc/application-context.xml")
public class RequestPartTest extends SpringTestEnv{

	//@RequestPart 테스트
	//url : /hello/uploadPicture 요청을 보내고
	//요청 결과가 정상이어야하고
	//응답 속성에 model 속성에 fileNm 속성이 존재해야 한다
	//응답 속성에 model 속성에 fileNm 값이 brwon.png
	//응답 view 이름은 /hello/uploadPicture url을 처리하는 메소드가 반환하는 string과 같아야 한다
	@Test
	public void requestPartTest() throws Exception {
		//업로드할 파일 준비
		File file = new File("D:\\A_TeachingMaterial\\7.JspSpring\\workspaceLuna\\spring\\src\\main\\webapp\\uploadTest\\brown.png");
		FileInputStream fis = new FileInputStream(file);
		MockMultipartFile multipartFile = new MockMultipartFile("picture", "brown.png", null, fis);
		//new MockMultipartFile
		
		//mockMvc를 통해 file uplaod
		mockMvc.perform(fileUpload("/hello/uploadPicture").file(multipartFile))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("fileNm"))
			.andExpect(model().attribute("fileNm", "brown.png"))
			.andExpect(view().name("uploadResult.jsp"));
			
	}

}
