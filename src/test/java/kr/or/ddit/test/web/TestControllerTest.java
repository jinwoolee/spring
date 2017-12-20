package kr.or.ddit.test.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/servlet-context.xml", 
								 "/config/spring/root-context.xml"})
@WebAppConfiguration		//WebApplicationContext 설정
public class TestControllerTest {
	Logger logger = LoggerFactory.getLogger(TestControllerTest.class);
	
	@Resource(name="testController")
	private TestController testController;
	
	@Test
	public void testDoTest() {
		/***Given***/
		
		/***When***/
		String view = testController.testPage();
		logger.debug("view : " + view);
		
		/***Then***/
		assertEquals("test", view);
	}
}