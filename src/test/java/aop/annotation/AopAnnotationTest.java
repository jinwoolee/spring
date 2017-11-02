package aop.annotation;

import static org.junit.Assert.*;   

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aop.target.AnnotationTarget;
import aop.target.FirstTarget;
import aop.target.SecondTarget;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class AopAnnotationTest {
	Logger logger = LoggerFactory.getLogger(AopAnnotationTest.class);
	
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