package conversion;
import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import conversion.model.FormattVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"application-context.xml"})
public class ConversionServiceTest {
	Logger logger = LoggerFactory.getLogger(ConversionServiceTest.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void conversionServiceTest() {
		/***Given***/
		FormattVo formattVo = applicationContext.getBean("formattVo", FormattVo.class);
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 9, 13, 0, 0, 0);
		
		/***When***/

		/***Then***/
		logger.debug(formattVo.toString());
		
		assertEquals(calendar.getTime().toString(),	 formattVo.getReg_dt().toString());
	}
}