package ddit.or.kr.bean.type.conversion;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ddit.or.kr.bean.type.ValueObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/ddit/or/kr/bean/type/conversion/application-context.xml"})
public class ConversionServiceTest {
	private Logger logger = LoggerFactory.getLogger(ConversionServiceTest.class);

	@Resource(name="valueObject")
	private ValueObject valueObject;
	
	//conversion servie 등록을 통해 string -> java.util.date로 변환하는 테스트
	@Test
	public void conversionServiceTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		logger.debug("valueObject.getDt() : {} ", valueObject.getDt());
		assertNotNull(valueObject);
		assertEquals("Wed Dec 20 00:00:00 KST 2017", valueObject.getDt().toString());

	}

}









