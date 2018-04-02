package ddit.or.kr.bean.type;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/bean/type/application-context.xml"})
public class DateTypeTest {
	private Logger logger = LoggerFactory.getLogger(DateTypeTest.class); 

	@Resource(name="valueObject")
	private ValueObject valueObject;
	
	@Test
	public void dateTypeTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		logger.debug("valueObject.getDt() : {} ", valueObject.getDt());
		assertNotNull(valueObject);
		assertEquals("Wed Dec 20 00:00:00 KST 2017", valueObject.getDt().toString());
	}
}

