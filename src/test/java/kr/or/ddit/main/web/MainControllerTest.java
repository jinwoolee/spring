package kr.or.ddit.main.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;

public class MainControllerTest extends ControllerTestConfig{
		
	@Test
	public void mainViewTest() throws Exception{
		/***Given***/
		MvcResult mvcResult = 
				mockMvc.perform(get("/main")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("main", mav.getViewName());
	}

}






