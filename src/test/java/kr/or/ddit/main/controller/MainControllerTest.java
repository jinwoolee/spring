package kr.or.ddit.main.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.testenv.ControllerTestEnv;

public class MainControllerTest extends ControllerTestEnv{
	
	/** 
	 * Method   : mainViewTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : Main View 호출 테스트 
	 * @throws Exception 
	 */
	@Test
	public void mainViewTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/main")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		String userId = (String)mav.getModel().get("mainUserId");

		/***Then***/
		assertEquals("main", viewName);
		assertEquals("brown", userId);
	}
	
	@Test
	public void mainViewAndExpectTest() throws Exception {

		mockMvc.perform(get("/main"))
					.andExpect(status().isOk())
					.andExpect(view().name("main"))
					.andExpect(model().attribute("mainUserId", "brown"));
		
	}

}










