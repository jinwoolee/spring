package kr.or.ddit.hello.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload; 
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.sessionAttribute.web.SessionAttributeController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:/kr/or/ddit/hello/web/application-context.xml"})
@WebAppConfiguration		//WebApplicationContext 설정
public class HelloControllerTest {

	Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);
	
	@Autowired 
	private WebApplicationContext ctx;
	private MockMvc mockMvc;		//dispatcher servlet
	
	@Autowired
	private HelloController helloController;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//hello web request test
	@Test
	public void helloWebTest() throws Exception{
		//given
		//MockHttpServletRequestBuilder
		/*
		–param(String name, String… values)
		–cookie(Cookie… cookies)
		–headers(String name, Object… values)
		–sessionAttr(String name, Object value)
		–contentType(MediaType mediaType)
		–content(String content)
		–contextPath(String contextPath)
		*/
		//–get(), post() 등 메서드는 MockHttpServletRequestBuilder를 리턴
		MvcResult mvcResult = mockMvc.perform(get("/hello.doo").param("userId", "brown"))
				.andExpect(status().isOk())
				.andExpect(view().name("hello"))
				.andExpect(model().attributeExists("localeInfo", "serverTime"))
				.andExpect(request().sessionAttribute("username", "brown"))
				//.andExpect))
				.andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		logger.debug("{}", mav.getModel().get("localeInfo"));
		
		//파일 업로드 테스트
		MockMultipartFile file = new MockMultipartFile("uuidfilename.txt", "filename.txt", "text/plain", "some xml".getBytes());
		fileUpload("/fileupload.do").file(file);

		//when

		//then
	}
}