package ddit.or.kr.bean.type.fmconversion;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/bean/type/fmconversion/application-context.xml"})
public class FormattingConversionTest {
	private Logger logger = LoggerFactory.getLogger(FormattingConversionTest.class);
	
	@Resource(name="valueObject")
	private ValueObject valueObject;
	
	//valueobject formatting conversion 테스트
	@Test
	public void formattingConversionTest() {
		/***Given***/

		/***When***/

		/***Then***/
		logger.debug("regDt : {}", valueObject.getRegDt());
		logger.debug("modDt : {}", valueObject.getModDt());
		logger.debug("price : {}", valueObject.getPrice());
		assertNotNull(valueObject);
		assertEquals(7000, valueObject.getPrice());
		assertEquals("Wed Dec 20 00:00:00 KST 2017", valueObject.getRegDt().toString());
		assertEquals("Wed Dec 20 00:00:00 KST 2017", valueObject.getModDt().toString());
		
	}

}






