package lifecycle;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class LifeCycleTest {

	Logger logger = LoggerFactory.getLogger(LifeCycleTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void lifeCycleTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertEquals(1, 1);
	}
}