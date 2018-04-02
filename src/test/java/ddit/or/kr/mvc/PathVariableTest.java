package ddit.or.kr.mvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import ddit.or.kr.SpringTestEnv;
@ContextConfiguration("classpath:/ddit/or/kr/mvc/application-context.xml")
public class PathVariableTest extends SpringTestEnv{
	private Logger logger = LoggerFactory.getLogger(PathVariableTest.class);

	//url : /hello/lineFriends/brown 요청을 보내고
	//요청 결과가 정상이어야하고
	//응답 속성에 model 속성에 friendName 속성이 존재해야 한다
	//응답 view 이름은 /hello/lineFriends/brown url을 처리하는 메소드가 반환하는 string과 같아야 한다
	
	@Test
	public void pathvatiableTest() throws Exception {
		ResultActions ra =
		mockMvc.perform(get("/hello/lineFriends/brown"))
				.andExpect(model().attributeExists("friendName"))
				.andExpect(view().name("lineFriendView.jsp"));
		
		MvcResult mr = ra.andReturn();
		ModelAndView mav = mr.getModelAndView();
		String friendName = (String) mav.getModel().get("friendName");
		assertEquals("brown hello", friendName);
		logger.debug(friendName);
	}

}






