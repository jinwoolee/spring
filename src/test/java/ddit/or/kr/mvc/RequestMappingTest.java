package ddit.or.kr.mvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import ddit.or.kr.SpringTestEnv;

/**
 * @RequestMapping
 * RequestMappingTest.java
 *
 * @author sam
 * @since 2017. 12. 22.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 22. sam 최초 생성
 *
 * </pre>
 */
@ContextConfiguration("classpath:/ddit/or/kr/mvc/application-context.xml")
public class RequestMappingTest extends SpringTestEnv{
	private Logger logger = LoggerFactory.getLogger(RequestMappingTest.class);

	//@RequestMapping HttpMehtod mappping(get)
	@Test
	public void httpMehtodGetTest() throws Exception {
		mockMvc.perform(get("/hello/requestMappingGet.do"))
		.andExpect(status().isOk())
		.andExpect(view().name("sayHello.jsp"));	//반환된 view 이름이 sayHello.jsp
	}
	
	//@RequestMapping HttpMehtod mappping(post)
	@Test
	public void httpMehtodPostTest() throws Exception {
		mockMvc.perform(post("/hello/requestMappingGet.do"))
		.andExpect(status().isOk())
		.andExpect(view().name("sayHello.jsp"));	//반환된 view 이름이 sayHello.jsp
	}
	
	//@RequestMapping params mappping
	@Test
	public void requestMappingParamsTest() throws Exception{
		mockMvc.perform(get("/hello").param("method", "insertMember"))
			.andExpect(status().isOk())
			.andExpect(view().name("sayHello.jsp"));
	}
	
	//@RequstMapping param exists
	@Test
	public void requestMappingParamsTest2() throws Exception{
		mockMvc.perform(get("/hello").param("userId", "brown"))
			.andExpect(status().isOk())
			.andExpect(view().name("sayHello.jsp"));
	}
	
	//@ModelAttribute test
	//url : /hello/lineFriends.do 요청 을보내고
	//요청 결과가 정상이어야하고
	//응답 속성에 @ModelAttribute에서 적용한 lineFriendsList 속성이 존재해야 한다
	//응답 view 이름은 /hello/lineFriends.do url을 처리하는 메소드가 반환하는 string과 같아야 한다
	
	@Test
	public void modelAttributeMethodTest() throws Exception{
		ResultActions ra = mockMvc.perform(get("/hello/lineFriends.do"))
				.andExpect(status().isOk())
				.andExpect(view().name("sayHello.jsp"))					//반환된 view 이름이 sayHello.jsp
				.andExpect(model().attributeExists("lineFriendsList"));		//model에 lineFriendsList 속성이 존재
		
		MvcResult mr = ra.andReturn();
		ModelAndView mav = mr.getModelAndView();
		List<String> lineFriendsList = (List<String>)mav.getModelMap().get("lineFriendsList");
		for(String str : lineFriendsList)
			logger.debug("{}", str);

	}
	
	//@ModelAttribute param test
	//url : /hello/lineFriendsMA.do 요청을 보내고
	//요청 결과가 정상이어야하고
	//응답 속성에 model 속성에 customList 속성이 존재해야 한다
	//응답 view 이름은 /hello/lineFriendsMA.do url을 처리하는 메소드가 반환하는 string과 같아야 한다
	@Test
	public void modelAttributeParamTest() throws Exception{
		ResultActions ra =  mockMvc.perform(get("/hello/lineFriendsMA.do"))
			.andExpect(status().isOk())
			.andExpect(view().name("sayHello.jsp"))
			.andExpect(model().attributeExists("customList"));
		
		MvcResult mr = ra.andReturn();
		ModelAndView mav = mr.getModelAndView();
		//modelMap, model
		List<String> customList = (List<String>)mav.getModelMap().get("customList");
		for(String str : customList)
			logger.debug("{}", str);
	}
	
	//@SessionAttributes
	//@ModelAttribute 최초 실행후 세션에 저장
	//이후 실행시에는 session에 있는 값을 가져와서 성능 향상에 도움
	
	//url : /hello/lineFriendsSA.do 요청을 보내고
	//요청 결과가 정상이어야하고
	//응답 속성에 model 속성에 lineFriendsList 속성이 존재해야 한다
	//응답 view 이름은 /hello/lineFriendsSA.do url을 처리하는 메소드가 반환하는 string과 같아야 한다
	
	//위 요청을 연달아서 한번더 반복 했을 때
	//@modelAttribute method의 logging이 한번만 표시가 되면 정상	 : 눈으로 확인하는 부분 (X assert)
	@Ignore		//추후 웹서버 설정후에 테스트 진행 (mockMvc 요청시 session이 유지 안되는 것으로 판단됨)
	public void sessionAttributesTest() throws Exception{
		mockMvc.perform(get("/hello/lineFriendsSA.do"))
				.andExpect(status().isOk())
				.andExpect(view().name("sayHello.jsp"))
				.andExpect(model().attributeExists("lineFriendsList"));
		
		mockMvc.perform(get("/hello/lineFriendsSA.do"))
				.andExpect(status().isOk())
				.andExpect(view().name("sayHello.jsp"))
				.andExpect(model().attributeExists("lineFriendsList"));
	}
	
}









