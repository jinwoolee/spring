package kr.or.ddit.test.web;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/servlet-context.xml", 
								 "/config/spring/root-context.xml"})
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