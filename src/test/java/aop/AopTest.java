package aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aop.target.FirstTarget;
import aop.target.SecondTarget;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class AopTest {
	Logger logger = LoggerFactory.getLogger(AopTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void aopTest() {
		logger.debug("start aopTest");
		
		//given
		FirstTarget		firstTarget		=	applicationContext.getBean("firstTarget", FirstTarget.class); 
		SecondTarget 	secondTarget		=	applicationContext.getBean("secondTarget", SecondTarget.class);
		
		//when
		firstTarget.firstTargetMethod();
		//logger.debug("\n");
		secondTarget.secondTargetMethod();
		
		//then
		logger.debug("end aopTest");
	}		
}