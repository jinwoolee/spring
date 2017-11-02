package aop.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aop.target.AnnotationTarget;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"application-context.xml"})
@ContextConfiguration(classes= {ApplicationConfig.class})
public class JavaConfigAopTest {
	Logger logger = LoggerFactory.getLogger(JavaConfigAopTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void aopAnnotationTest() {
		logger.debug("start aopAnnotationTest");
		
		//given
		AnnotationTarget	annotationTarget	=	applicationContext.getBean("annotationTarget", AnnotationTarget.class); 
		
		//when
		annotationTarget.annotationTargetMethod();
		
		//then
		logger.debug("end aopAnnotationTest");
	}		
}