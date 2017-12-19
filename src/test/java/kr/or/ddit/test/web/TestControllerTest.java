package kr.or.ddit.test.web;

import static org.junit.Assert.*;

import javax.annotation.Resource;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/servlet-context.xml", 
								 "/config/spring/root-context.xml"})
@WebAppConfiguration		//WebApplicationContext 설정
public class TestControllerTest {
	Logger logger = LoggerFactory.getLogger(TestControllerTest.class);

	@Autowired 
	private WebApplicationContext ctx;
	private MockMvc mockMvc;		//dispatcher servlet
	
	@Resource(name="testController")
	private TestController testController;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void pageRequestTest() {
		//given
		//mockMvc.perform(requestBuilder)
		//when

		//then
	}
	
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