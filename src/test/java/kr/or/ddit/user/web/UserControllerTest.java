package kr.or.ddit.user.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;


public class UserControllerTest extends ControllerTestConfig{
	
	/**
	* Method : test
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : loginView test
	*/
	@Test
	public void loginViewTest() throws Exception{
		/***Given***/
		MvcResult mvcResult = 
				mockMvc.perform(get("/user/loginView")).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		//viewName
		assertEquals("login/login", mav.getViewName());
	}
	
	/**
	* Method : loginProcessTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : loginProcessTest
	*/
	@Test
	public void loginProcessSuccessTest() throws Exception{
		/***Given***/
		MvcResult mvcResult = 
				mockMvc.perform(post("/user/loginProcess")
								.param("userId", "brown")
								.param("pass", "brownpass"))
								.andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("main", mav.getViewName());
	}
	
	@Test
	public void loginProcessFailTest() throws Exception{
		/***Given***/
		MvcResult mvcResult = 
				mockMvc.perform(post("/user/loginProcess")
								.param("userId", "browm")
								.param("pass", "brownpass"))
								.andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}

}










