package ddit.or.kr.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import ddit.or.kr.SpringTestEnv;

@ContextConfiguration("classpath:/ddit/or/kr/mvc/application-context.xml")
public class ModelAndViewTest extends SpringTestEnv{

	//ModelAndView 객체를 통한 view, model 전달
	@Test
	public void modelAndViewTest() throws Exception{
		mockMvc.perform(get("/hello/modelAndView.do"))
			.andExpect(status().is(200))		//is(200) == isOk()
			.andExpect(model().attribute("modelUserNm", "modelBrown"))
			.andExpect(model().attribute("modelMapUserNm", "modelMapBrown"))
			.andExpect(model().attribute("mavUsreNm", "mavBrown"))
			.andExpect(view().name("mav.jsp"));
	}

}
