package kr.or.ddit.mvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

public class MvcControllerTest extends ControllerTestConfig{

	private Logger logger = LoggerFactory.getLogger(MvcControllerTest.class);

	@Test
	public void mvcViewTest() throws Exception{
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/view")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<String> rangers = (List<String>)mav.getModel().get("rangers");

		/***Then***/
		assertEquals("mvc/view", viewName);
		
		//model객체에서 rangers 리스트 속성을 받아 사이즈가 3인지 체크
		//(controller에서 한건 추가)
		assertEquals(4, rangers.size());
	}
	
	@Test
	public void mvcView2Test() throws Exception{
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/view2")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<String> rangers = (List<String>)mav.getModel().get("rangers");

		/***Then***/
		assertEquals("mvc/view", viewName);
		
		//model객체에서 rangers 리스트 속성을 받아 사이즈가 3인지 체크
		assertEquals(3, rangers.size());
	}
	
	@Test
	public void fileuploadViewTest() throws Exception{
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/fileupload")).andReturn();

		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("mvc/fileuploadView", mav.getViewName());
	}
	
	

}













